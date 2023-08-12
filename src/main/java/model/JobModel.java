package model;

public class JobModel {
    private int id;


    private String jobName;
    private String ngaybatdau;
    private String ngayketthuc;

    public String getJobName() {
        return jobName;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
