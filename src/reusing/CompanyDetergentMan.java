package reusing;

/**
* @Description:公司代理人
* @Author:hxw
* @Date:2018/3/31 13:51
*/
public class CompanyDetergentMan {

    private Company company = new Company();

    public void payOff() {
        company.payOff();  //这就是代理
    }

    public void doBusiness() {
        company.doBusiness();
    }

    public void Cooperation() {
        company.Cooperation();
    }

    public static void main(String[] args){
        CompanyDetergentMan companyDetergentMan = new CompanyDetergentMan();
        companyDetergentMan.doBusiness();
    }
}
