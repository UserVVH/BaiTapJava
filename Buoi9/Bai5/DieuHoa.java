package hello;

public class DieuHoa extends ThietBiDien {
	private boolean lamLanh;
	private int nhietDo;

	public DieuHoa(String ten, int congSuat, boolean lamLanh, int nhietDo) {
		super(ten, congSuat);
		this.lamLanh = lamLanh;
		this.nhietDo = nhietDo;
	}

	@Override
	public void hienThongTin() {
		super.hienThongTin();
	}

	public void bat() {
		System.out.println("Điều hòa đang bật");
		if (lamLanh) {
			System.out.println("Chức năng Làm lạnh đang bật");
		} else {
			System.out.println("Chức năng Làm nóng đang bật");
		}
		System.out.println("Nhiệt độ hiện tại: " + nhietDo + " độ");
	}

	public void tat() {
		System.out.println("Điều hòa đã tắt");
	}

	public void giamNhietDo(int doC) {
		nhietDo -= doC;
		System.out.println("Giảm " + doC + " độ. Nhiệt độ hiện tại: " + nhietDo + " độ");
	}

	public void tangNhietDo(int doC) {
		nhietDo += doC;
		System.out.println("Tăng " + doC + " độ. Nhiệt độ hiện tại: " + nhietDo + " độ");
	}

}
