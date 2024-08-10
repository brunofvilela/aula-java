package br.com.syonet;

class Car extends Veiculo{
    String model = "";
    int year = 2024;

    @Override
    public String toString(){
        return """
        {
            "model": "%s",
            "year": %d,
            "velocidade": %d
        }     
        """.formatted(this.model,this.year,this.velocidade);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
    }
    
}
