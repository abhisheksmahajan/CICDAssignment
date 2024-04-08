package Goresttests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Config;

public class Tets_api {
    Post_req post;
    Get_req get;
    Put_req put;
    Delete_req delete;

    @BeforeTest
    void setup(){
     post= new Post_req();
     get= new Get_req();
     put= new Put_req();
     delete= new Delete_req();
    }
    @Test(priority = 0 , description = "Verify that Create user with valid credentials.")
    void Createuser1(){
        Assert.assertEquals(post.postrequest(Random1.generateRandomName(),Random1.generateDynamicEmail(),"female","active"),201);
    }
    @Test(priority = 1 , description = "Verify that Create user with inactive Status .")
    void Createuser2(){
        Assert.assertEquals(post.postrequest(Random1.generateRandomName(),Random1.generateDynamicEmail(),"female","inactive"),201);
    }
    @Test(priority = 2 , description = "Verify that User should not Create user with null email id .")
    void Createuser3(){
        Assert.assertEquals(post.invalidpostrequest(Random1.generateRandomName(),null,"female","inactive"),422);
    }
    @Test(priority = 3 , description = "Verify that User should not Create user with null name .")
    void Createuser4(){
        Assert.assertEquals(post.invalidpostrequest(null,Random1.generateDynamicEmail(),"female","inactive"),422);
    }
    @Test(priority = 4 , description = "Verify that User should not Create user with null name and email id .")
    void Createuser5(){
        Assert.assertEquals(post.invalidpostrequest(null,null,"female","inactive"),422);
    }
    @Test(priority = 5 , description = "Verify that User should not Create user with Same email id .")
    void Createuser6(){
        Assert.assertEquals(post.invalidpostrequest(Random1.generateRandomName(),"Anushka507@gmail.com","female","active"),422);
    }
    @Test(priority = 6 , description = "Verify that User should not Create user with null gender  .")
    void Createuser7(){
        Assert.assertEquals(post.invalidpostrequest(Random1.generateRandomName(),"Anushka507@gmail.com",null,"active"),422);
    }
    @Test(priority = 7 , description = "Verify that User should not Create user with invalid  gender  .")
    void Createuser8(){
        Assert.assertEquals(post.invalidpostrequest(Random1.generateRandomName(),Random1.generateDynamicEmail(),"asdfsdsd","active"),422);
    }
    @Test(priority = 8 , description = "Verify that User should not Create user with null status .")
    void Createuser9(){
        Assert.assertEquals(post.invalidpostrequest(Random1.generateRandomName(),Random1.generateDynamicEmail(),"female",null),422);
    }
    @Test(priority = 9 , description = "Verify that User should get all user list .")
    void Getuserlist1(){
        Assert.assertEquals(get.getall(),200);
    }
    @Test(priority = 10 , description = "Verify that User should get user details with valid user id .")
    void Getuserlist2(){
        Assert.assertEquals(get.getId(Config.userId),200);
    }
    @Test(priority = 11 , description = "Verify that User should get user details with invalid user id .")
    void Getuserlist3(){
        Assert.assertEquals(get.getId("11111"),404);
    }
    @Test(priority = 12 , description = "Verify that User should get user details with Alfa numeric user id .")
    void Getuserlist4(){
        Assert.assertEquals(get.getId(" 1452@"),404);
    }
    @Test(priority = 13 , description = "Verify that User should update details with valid information .")
    void Updateuser1(){
        Assert.assertEquals(put.updateUser(Random1.generateRandomName(),Random1.generateDynamicEmail(),"female","active"),200);
    }
    @Test(priority = 14 , description = "Verify that User should update details with inactive Status .")
    void Updateuser2(){
        Assert.assertEquals(put.updateUser(Random1.generateRandomName(),Random1.generateDynamicEmail(),"female","inactive"),200);
    }
    @Test(priority = 15 , description = "Verify that User should not update details with invalid information.")
    void Updateuser4(){
        Assert.assertEquals(put.updateUser(Random1.generateRandomName(),"abc.com","female","active"),422);
    }
    @Test(priority = 16 , description = "Verify that User should not update details with null email id.")
    void Updateuser5(){
        Assert.assertEquals(put.invalidputrequest(Random1.generateRandomName(),null,"female","active"),404);
    }
    @Test(priority = 17 , description = "Verify that User should not update details with null name.")
    void Updateuser6(){
        Assert.assertEquals(put.invalidputrequest(null,"abc@gmail.com","female","active"),404);
    }
    @Test(priority = 18 , description = "Verify that User should not update details with invalid gender type.")
    void Updateuser7(){
        Assert.assertEquals(put.updateUser(null,"abc@gmail.com","yzyz","active"),422);
    }
    @Test(priority = 19 , description = "Verify that User should not update details with null gender fild .")
    void Updateuser8(){
        Assert.assertEquals(put.invalidputrequest(Random1.generateRandomName(),Random1.generateDynamicEmail(),null,"active"),404);
    }
    @Test(priority = 20 , description = "Verify that User should delete record with valid id .")
    void Deleteuser1(){
        Assert.assertEquals(delete.DeleteUser(Config.userId),204);
    }
    @Test(priority = 21 , description = "Verify that User should not delete non existing record id .")
    void Deleteuser2(){
        Assert.assertEquals(delete.DeleteUser(Config.userId),404);
    }
    @Test(priority = 22 , description = "Verify that User should not delete record with invalid id .")
    void Deleteuser3(){
        Assert.assertEquals(delete.DeleteUser("1123@"),404);
    }




}
