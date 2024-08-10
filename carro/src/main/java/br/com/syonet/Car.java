package br.com.syonet;

class Car implements Veiculo{
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
        """.formatted(this.model,this.year,this.getVelocidade());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    @Override
    public long getVelocidade() {
        return 20;
    }
    
}
