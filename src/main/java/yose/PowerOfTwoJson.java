package yose;

import java.util.List;

public class PowerOfTwoJson {
	private Integer number;
	
	private List<Integer> decomposition;
	
	public PowerOfTwoJson(Integer number, List<Integer> decomposition){
		this.number = number;
		
		this.decomposition = decomposition;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<Integer> getDecomposition() {
		return decomposition;
	}

	public void setDecomposition(List<Integer> decomposition) {
		this.decomposition = decomposition;
	}
	
	
}
