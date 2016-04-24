package br.univel.enums;

public enum EstadoCivil {
	SOLTEIRO,
	CASADO,
	DIVORCIADO,
	VIUVO;
	
	public static final EstadoCivil getPorCodigo(int value){
        for (EstadoCivil item : EstadoCivil.values()) {
            if (item.ordinal() == value) {
            	return item;
            }
        }
		throw new RuntimeException("Valor não encontrado: " + value);
	}
}
