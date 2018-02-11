package logic;

public class Computer {
	private String producer;
	private int model;
	
	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return getProducer() + " " + getModel();
	}
	
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Computer))
            return false;
        Computer comp = (Computer) obj;
        if(producer != null)
            if(producer.equals(comp.getProducer()) && comp.getModel() == this.model)
                return true;
        return false;
    }

	public Computer(String producer, int model) {
		setProducer(producer);
		setModel(model);
	}
}
