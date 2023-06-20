package ms.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(propOrder = {"mssv","hoten","ngaysinh"})
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long mssv;
	private String hoten;
	private Date ngaysinh;
	public long getMssv() {
		return mssv;
	}
	public void setMssv(long mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Person(long mssv, String hoten, Date ngaysinh) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
	}
	public Person() {
		
	}
	@Override
	public String toString() {
		return "Person [mssv=" + mssv + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + "]";
	}
	
	
}
