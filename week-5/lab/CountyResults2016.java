
public class CountyResults2016 {
	
	public double demVotes = 0;
	public double gopVotes = 0;
	public double totalVotes = 0;
	public double percentDem = 0;
	public double percentGOP = 0;
	public double difference = 0;
	public double percentDifference = 0;
	public String stateAbbreviation = "";
	public String county = "";
	public int flips = 0;
	
	public CountyResults2016() {}
	
	public CountyResults2016(double demVotes, double gopVotes, double totalVotes, double percentDem, double percentGOP,
double difference, double percentDifference, String stateAbbreviation, String county, int flips) {
		this.demVotes = demVotes;
		this.gopVotes = gopVotes;
		this.totalVotes = totalVotes;
		this.percentDem = percentDem;
		this.percentGOP = percentGOP;
		this.difference = difference;
		this.percentDifference = percentDifference;
		this.stateAbbreviation = stateAbbreviation;
		this.county = county;
		this.flips = flips;
	}
	
	
	
	public double getTotalVotes() {
		return totalVotes;
	}
	
	public double getDemVotes() {
		return demVotes;
	}
	
	public double getGOPVotes() {
		return gopVotes;
	}
	
	public double getDifference() {
		return difference;
	}
	
	public double getPercentDifference() {
		return percentDifference;
	}
	
	public String getState() {
		return stateAbbreviation;
	}
	
	public String getCounty() {
		return county;
	}
	
	public String toString() {
		String message = "The Election Stats Are As Follows:\n"
				+  "Total Votes: " + totalVotes + "\nDemocratic Votes: " + demVotes + "\nGOP Votes: " + gopVotes
				+ "\nDemocratic Percentage: " + percentDem + "\nGOP Percentage: " + percentGOP + "\nDifference: "
				+ difference + "\nPercent Difference: " + percentDifference + "\nState: " + stateAbbreviation
				+ "\nCounty: " + county + "\nFlip Count: " + flips;
		return message;
	}

}
