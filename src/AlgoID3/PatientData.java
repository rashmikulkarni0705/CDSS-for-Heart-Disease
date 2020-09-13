package AlgoID3;

import java.sql.CallableStatement;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.activation.DataSource;

public class PatientData {

    public PatientData() {
    }

//    public static boolean isDublicate(PatientForm PatientFormObj) throws Exception {
////
////        Connection con = null;
////        CallableStatement cstmt = null;
////        ResultSet rs = null;
////
////        ArrayList al = null;
////        try {
////            con = DataBase.con;
////            String Query = "Select * from Patient where name = :1 and ACTIVE='1' and (   patientid<>:2 ) ";
////            cstmt = con.prepareCall(Query);
////            cstmt.setString(1, PatientFormObj.getName());
////            cstmt.setInt(2, PatientFormObj.getPatientid());
////
////
////            cstmt.executeQuery();
////            rs = cstmt.executeQuery();
////            if (rs.next()) {
////                return true;
////
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        } finally {
////            if (rs != null) {
////                rs.close();
////            }
////            if (cstmt != null) {
////                cstmt.close();
////            }
////        }
////        return false;
//    }
    public static int insertPatient(PatientForm PatientFormObj) throws Exception {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int flag = 0;
        try {
            con = DataBase.con;
            String Query = "";
            Query = "INSERT INTO Patient (  name ,  address ,  contactno ,  val1 ,  val2 ,  val3 ,  val4 ,  val5 ,  val6 ,  val7 , val8 , val9 , val10, val11 , val12 , val13 , flag  ,active ) "
                    + " VALUES (  :1 ,  :2 ,  :3 ,  :4 ,  :5 ,  :6 ,  :7 ,  :8 ,  :9 ,  :10 ,  :11 , :12 ,:13 ,:14 ,:15 ,:16 ,:17 , '1') ";
            cstmt = con.prepareCall(Query);

            cstmt.setString(1, PatientFormObj.getName());
            cstmt.setString(2, PatientFormObj.getAddress());
            cstmt.setString(3, PatientFormObj.getContactno());
            cstmt.setFloat(4, PatientFormObj.getVal1());
            cstmt.setFloat(5, PatientFormObj.getVal2());
            cstmt.setFloat(6, PatientFormObj.getVal3());
            cstmt.setFloat(7, PatientFormObj.getVal4());
            cstmt.setFloat(8, PatientFormObj.getVal5());
            cstmt.setFloat(9, PatientFormObj.getVal6());
            cstmt.setFloat(10, PatientFormObj.getVal7());
            
            cstmt.setFloat(11, PatientFormObj.getVal8());
            cstmt.setFloat(12, PatientFormObj.getVal9());
            cstmt.setFloat(13, PatientFormObj.getVal10());
            cstmt.setFloat(14, PatientFormObj.getVal11());
            cstmt.setFloat(15, PatientFormObj.getVal12());
            cstmt.setFloat(16, PatientFormObj.getVal13());
            cstmt.setString(17, PatientFormObj.getFlag());


            flag = cstmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cstmt != null) {
                cstmt.close();
            }

        }
        return flag;
    }

    public static int modifyPatient(PatientForm PatientFormObj) throws Exception {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int flag = 0;
        try {
            con = DataBase.con;
            String Query = "";
            Query = "UPDATE Patient  SET    name = :1 ,  address = :2 ,  contactno = :3 , val1  = :4 ,  val2 = :5 ,  val3 = :6 ,  val4 = :7 ,  val5 = :8 ,  val6 = :9 ,  val7 = :10,val8 = :11 ,val9 = :12 ,val10 = :13 ,val11 = :14 ,val12 = :15 ,val13 = :16 ,  flag = :17   where patientid=:18 ";
            cstmt = con.prepareCall(Query);

            cstmt.setString(1, PatientFormObj.getName());
            cstmt.setString(2, PatientFormObj.getAddress());
            cstmt.setString(3, PatientFormObj.getContactno());
            cstmt.setFloat(4, PatientFormObj.getVal1());
            cstmt.setFloat(5, PatientFormObj.getVal2());
            cstmt.setFloat(6, PatientFormObj.getVal3());
            cstmt.setFloat(7, PatientFormObj.getVal4());
            cstmt.setFloat(8, PatientFormObj.getVal5());
            cstmt.setFloat(9, PatientFormObj.getVal6());
            cstmt.setFloat(10, PatientFormObj.getVal7());
            cstmt.setFloat(11, PatientFormObj.getVal8());
            
            cstmt.setFloat(12, PatientFormObj.getVal9());
            cstmt.setFloat(13, PatientFormObj.getVal10());
            cstmt.setFloat(14, PatientFormObj.getVal11());
            cstmt.setFloat(15, PatientFormObj.getVal12());
            cstmt.setFloat(16, PatientFormObj.getVal13());
            cstmt.setString(17, PatientFormObj.getFlag());
            
            //cstmt.setString(12, PatientFormObj.getFlag());


            cstmt.setInt(18, PatientFormObj.getPatientid());

            flag = cstmt.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cstmt != null) {
                cstmt.close();
            }

        }
        return flag;
    }

    public static int deletePatient(int pk) throws Exception {
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int flag = 0;
        try {
            con = DataBase.con;
            String Query = "";
            Query = "UPDATE Patient  SET  ACTIVE='0' WHERE patientid=:1 ";
            cstmt = con.prepareCall(Query);
            cstmt.setInt(1, pk);
            flag = cstmt.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cstmt != null) {
                cstmt.close();
            }

        }
        return flag;
    }

    public static PatientForm getEditPatient(int pk) throws Exception {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        PatientForm PatientFormObj = new PatientForm();
        try {
            con = DataBase.con;
            String Query = "SELECT   patientid ,  name ,  address ,  contactno ,  val1 ,  val2 ,  val3 ,  val4 ,  val5 ,  val6 ,  val7 ,  val8, val9 , val10 , val11 , val12 , val13 , flag   from Patient where patientid=:1  ";
            cstmt = con.prepareCall(Query);
            cstmt.setInt(1, pk);


            rs = cstmt.executeQuery();
            while (rs.next()) {
                PatientFormObj.setPatientid(rs.getInt("patientid"));
                PatientFormObj.setName(rs.getString("name"));
                PatientFormObj.setAddress(rs.getString("address"));
                PatientFormObj.setContactno(rs.getString("contactno"));
                PatientFormObj.setVal1(rs.getFloat("val1"));
               
                 PatientFormObj.setVal2(rs.getFloat("val2"));
                PatientFormObj.setVal3(rs.getFloat("val3"));
                PatientFormObj.setVal4(rs.getFloat("val4"));
                PatientFormObj.setVal5(rs.getFloat("val5"));
                PatientFormObj.setVal6(rs.getFloat("val6"));
                PatientFormObj.setVal7(rs.getFloat("val7"));
                PatientFormObj.setVal8(rs.getFloat("val8"));
                  
                PatientFormObj.setVal9(rs.getFloat("val9"));
                PatientFormObj.setVal10(rs.getFloat("val10"));
                PatientFormObj.setVal11(rs.getFloat("val11"));
                PatientFormObj.setVal12(rs.getFloat("val12"));
                PatientFormObj.setVal13(rs.getFloat("val13"));
                PatientFormObj.setFlag(rs.getString("flag"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cstmt != null) {
                cstmt.close();
            }

        }
        return PatientFormObj;
    }

    public static ArrayList getQueryPatientResultSet() throws Exception {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        PatientForm PatientFormObj = new PatientForm();
        ArrayList al = null;
        try {
            con = DataBase.con;
            String Query = "SELECT   patientid ,  name ,  address ,  contactno ,  val1 ,  val2 ,  val3 ,  val4 ,  val5 , "
                    + " val6 ,  val7 , val8 , val9 , val10 , val11 , val12 , val13 ,  flag   from Patient  WHERE   ACTIVE='1'  ";
            cstmt = con.prepareCall(Query);


            rs = cstmt.executeQuery();
            al = getPatientRSAarryList(rs);
        } catch (Exception e) {
            System.out.println("getQueryPatient()  : " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cstmt != null) {
                cstmt.close();
            }

        }
        return al;
    }

    public static ArrayList getPatientRSAarryList(ResultSet rs) throws Exception {

        ArrayList al = new ArrayList();

        try {
            while (rs.next()) {
                PatientForm PatientFormObj = new PatientForm();
                PatientFormObj.setPatientid(rs.getInt("patientid"));
                PatientFormObj.setName(rs.getString("name"));
                PatientFormObj.setAddress(rs.getString("address"));
                PatientFormObj.setContactno(rs.getString("contactno"));
                PatientFormObj.setVal1(rs.getFloat("val1"));
                PatientFormObj.setVal2(rs.getFloat("val2"));
                PatientFormObj.setVal3(rs.getFloat("val3"));
                PatientFormObj.setVal4(rs.getFloat("val4"));
                PatientFormObj.setVal5(rs.getFloat("val5"));
                PatientFormObj.setVal6(rs.getFloat("val6"));
                PatientFormObj.setVal7(rs.getFloat("val7"));
                PatientFormObj.setVal8(rs.getFloat("val8"));
                PatientFormObj.setVal9(rs.getFloat("val9"));
                PatientFormObj.setVal10(rs.getFloat("val10"));
                PatientFormObj.setVal11(rs.getFloat("val11"));
                PatientFormObj.setVal12(rs.getFloat("val12"));
                PatientFormObj.setVal13(rs.getFloat("val13"));
                PatientFormObj.setFlag(rs.getString("flag"));


                al.add(PatientFormObj);
            }
        } catch (Exception e) {
            System.out.println("getPatientRSAarryList()  : " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return al;
    }
}
