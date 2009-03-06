public class Files
{
	public String	fileName	= null;
	public String	md5sum		= null;

	public Files(String name, String md5sum)
	{
		this.fileName = name;
		this.md5sum = md5sum;
	}

	public String toString()
	{
		return "\tfile:\t" + this.fileName + " (md5: " + this.md5sum + ")";
	}

	public String toXMLFormat()
	{
		return "\t<File name = \"" + this.fileName + "\" md5 =\"" + this.md5sum + "\"></File>\n";
	}
}
