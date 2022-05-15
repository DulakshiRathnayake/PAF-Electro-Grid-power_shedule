package Frontend;
import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class psheduler {
	private int pLid;
	private String pLocation;
	private String pDuration;
	private String pReason;
	private String pDescription;
	public int getpLid() {
		return pLid;
	}
	public void setpLid(int pLid) {
		this.pLid = pLid;
	}
	public String getpLocation() {
		return pLocation;
	}
	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}
	public String getpDuration() {
		return pDuration;
	}
	public void setpDuration(String pDuration) {
		this.pDuration = pDuration;
	}
	public String getpReason() {
		return pReason;
	}
	public void setpReason(String pReason) {
		this.pReason = pReason;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	@Override
	public String toString() {
		return "psheduler [pLid=" + pLid + ", pLocation=" + pLocation + ", pDuration=" + pDuration
				+ ", pReason=" + pReason + ", pDescription=" + pDescription + "]";
	}
	
	
}
