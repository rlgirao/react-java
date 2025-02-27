package com.embracon.teste.service.cep;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import com.embracon.teste.dto.cep.CepDTO;
import com.embracon.teste.dto.cep.CepRetornoApiDTO;
import com.embracon.teste.exception.negocio.BusinessException;
import com.embracon.teste.mapper.cep.CepMapper;
import com.embracon.teste.mapper.log.LogMapper;
import com.embracon.teste.service.log.LogService;
import com.embracon.teste.utils.cep.CepUtil;

@Service
public class CepServiceImpl implements CepService {
	
	private static final String URL_API_VIA_CEP = "https://viacep.com.br/ws/";
	private LogService logService;
	private final RestClient restClient;
	
	public CepServiceImpl(LogService logService) {
		super();
		this.logService = logService;
		this.restClient = RestClient.create();
	}

	@Override
	public CepDTO consultarCep(String cep) {
		CepUtil.validarCep(cep);
		CepDTO cepRetornoViaCep = CepMapper.fromCEPRetornoApiDTOToCepDTO(consultarViaCepApi(cep));
		logService.salvar(LogMapper.fromCepDTOtoLogDTO(cepRetornoViaCep));
		return cepRetornoViaCep;
	}

	private CepRetornoApiDTO consultarViaCepApi(String cep) {
		String url = new StringBuilder().append(URL_API_VIA_CEP).append(cep).append("/json").toString();
		try {
			ResponseEntity<CepRetornoApiDTO> response = restClient.get()
					.uri(url)
					.retrieve()
					.toEntity(CepRetornoApiDTO.class);
			
			return response.getBody();			
		} catch (HttpClientErrorException e) {
	        throw new ServiceException("CEP inválido ou não encontrado.");
	    } catch (HttpServerErrorException e) {
	        throw new ServiceException("Erro no serviço externo de CEP.", e);
	    } catch (ResourceAccessException e) {
	        throw new ServiceException("Serviço de CEP fora do ar.", e);
	    } catch (Exception e) {
	        throw new BusinessException("Erro ao buscar dados do CEP: " + e.getMessage());
	    } 
	}

}
