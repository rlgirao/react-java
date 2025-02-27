import { observer } from 'mobx-react-lite';
import { useState } from 'react';
import { cepController } from '../controller/cep.controller';
import { ICep, IError } from '../controller/cep.inteface';
import Loading from '../../../components/loading/loading';
import { util } from '../../../helpers/util';
import Button from '../../../components/button/button';
import Input from '../../../components/input/input';

const Cep = observer(() => {
  const [cep, setCep] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const handleCepChange = (e: React.ChangeEvent<HTMLInputElement>): void => {
    setCep(util.formatCep(e.target.value.replace(/\D/g, '')));

    setError('');

    cepController.error = {} as IError;
  };

  const handleClearClick = () => {
    setCep('');
    setError('');
    cepController.cep = {} as ICep;
    cepController.error = {} as IError;
  };

  const handleBuscarClick = async () => {
    if (!cep) {
      setError('Por favor, insira um CEP válido.');
      return;
    }

    setLoading(true);

    await cepController.getCep(cep.replace(/\D/g, ''));
    
    setLoading(false);
  };

  return (
    <div className="relative flex w-full">
      {loading && <Loading />}
      <div className="flex flex-col w-full gap-2.5">
        <div className="flex flex-row w-full">
          <div className="flex flex-col gap-0.5 w-full">
            <Input
              type="text"
              id="cep"
              label="CEP"
              value={cep}
              onChange={handleCepChange}
              error={error ? error : (Object.keys(cepController.error).length > 0 && cepController.error.message) ? cepController.error.message : ''}
            />
          </div>
        </div>

        <div className="flex flex-row gap-2.5 w-full">
          <Button
            onClick={handleBuscarClick}
            className="bg-blue-500 text-white"
          >
            Buscar
          </Button>

          <Button
            onClick={handleClearClick}
            className="bg-gray-300 text-black"
          >
            Limpar
          </Button>
        </div>

        {cepController.cep && Object.keys(cepController.cep).length > 0 && (
          <div className="flex justify-center w-full">
            <pre className="bg-gray-800 text-white p-4 rounded-md overflow-auto w-full">
              {JSON.stringify(cepController.cep, null, 2)}
            </pre>
          </div>
        )}
      </div>
    </div>
  );
});

export default Cep;