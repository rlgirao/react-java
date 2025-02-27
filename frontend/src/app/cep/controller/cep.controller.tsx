import { action, observable, makeAutoObservable } from 'mobx';
import { api } from '../../../api/api';
import { ICep, IError } from './cep.inteface';

class CepController {

  @observable private _cep: ICep = {} as ICep;

  @observable private _error: IError = {} as IError;

  constructor() {
    makeAutoObservable(this);
  }

  get cep(): ICep {
    return this._cep;
  }

  @action
  set cep(value: ICep) {
    this._cep = value;
  }

  get error(): IError {
    return this._error;
  }

  @action
  set error(value: IError) {
    this._error = value;
  }

  @action
  public async getCep(cep: string): Promise<void> {
    try {
      const response = await api.get(`/cep/consulta-cep/${cep}`);

      this._cep = response.data;
      
      this._error = {} as IError;
    } catch (error) {
      this.cep = {} as ICep;
      this.error = { message: 'CEP inválido.' };
      console.error('Erro ao buscar cep', error);
      return undefined;
    }
  }
}

export const cepController = new CepController();
