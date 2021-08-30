package spring;

public class VersionPrinter {
	
	private int majorVersion;
	private int minorVersion;
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
	
	public VersionPrinter() {
		System.out.println("VersionPrinter()");
	}
	
	public void versionPrint() {
		System.out.println("v" + majorVersion + "." + minorVersion);
	}
}




