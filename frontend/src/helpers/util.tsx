class Utils {
  public formatCep(cep: string): string {
    if (cep.length > 8) {
      cep = cep.slice(0, 8);
    }
    
    if (cep.length > 5) {
      cep = cep.replace(/^(\d{5})(\d)/, '$1-$2');
    }
    
    return cep;
  }
  
}

export const util = new Utils();