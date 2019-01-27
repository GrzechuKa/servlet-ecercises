package pl.sdacademy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginValidatorTest {

    private LoginValidator loginValidator;

    private static String USERNAME = "Javaktw9";
    private static String PASSWORD = "SDA2019";

    @Before
    public void steup(){
         loginValidator = new LoginValidator();
    }

    @Test
    public void schouldReturnFalseWhenUsernameIsEmpty (){
       //given
        String userName = "";

        //when
        boolean result = loginValidator.isValid(userName, PASSWORD);
        //then
        assertFalse(result);
    }

    @Test
    public void schouldReturnFalseWhenPasswordIsEmpty (){
        //given
        String password = "";

        //when
        boolean result = loginValidator.isValid(USERNAME, password);
        //then
        assertFalse(result);
    }

    @Test
    public void schouldReturnFalseWhenUsernameIsShor6 (){
        //given
        String userName = "Java";
        //when
        boolean result = loginValidator.isValid(userName, PASSWORD);
        //then
        assertFalse(result);
    }

    @Test
    public void schouldReturnFalseWhenPasswordIsShor6 (){
        //given
        String password = "SDA";
        //when
        boolean result = loginValidator.isValid(USERNAME, password);
        //then
        assertFalse(result);
    }
    @Test
    public void schouldReturnFalseWhenUserNameIsNotSensitive (){
        //given
        String userName = "javaktw9";
        //when
        boolean result = loginValidator.isValid(userName, PASSWORD);
        //then
        assertFalse(result);
    }
    @Test
    public void schouldReturnFalseWhenPasswordIsNotSensitive (){
        //given
        String password = "sda2019";
        //when
        boolean result = loginValidator.isValid(USERNAME, password);
        //then
        assertFalse(result);
    }





    @Test
    public void schouldReturnTrueWhenUsernameAndPasswordIsOK (){
        //given

        //when
        boolean result = loginValidator.isValid(USERNAME, PASSWORD);
        //then
        assertTrue(result);
    }






}