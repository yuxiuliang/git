import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * 作者：余秀良
 * 时间：2015年 02月 04日 上午10:12
 * 地点：成都
 * 描述：
 * 备注：
 */
public class GameTest {
    private PrintStream out;
    private Game game;
    private BufferedReader red;
    private AnswerGenerator answer;
    private  InOrder inOrder;
    @Before
    public void set_up() throws IOException {
        out= mock(PrintStream.class);
        red = mock(BufferedReader.class);
         answer = mock(AnswerGenerator.class);
        CompareNumber com = new CompareNumber();
        game = new Game(out,red,answer,com);
        inOrder = inOrder(out);
        given(red.readLine()).willReturn("1234");
        given(answer.getgenerate()).willReturn("4321");
    }

    @Test
    public void test_welcome() throws IOException {
        verify(out, never()).println("welcome");
        game.start();
        verify(out).println("welcome");
    }
    @Test
    public void should_print_welcome_first_when_game__start() throws IOException {
        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("welcome");
        inOrder.verify(out).println("Please input your number(6)");
    }
    @Test
    public void should_print_please_input_you_number6_() throws IOException {
        game.start();
        inOrder.verify(out).println("welcome");
        inOrder.verify(out).println("Please input your number(6)");
        inOrder.verify(out).println("0A4B");

    }
    @Test
    public void should_print_please_input_you_number5_() throws IOException {
        game.start();
        inOrder.verify(out).println("welcome");
        inOrder.verify(out).println("Please input your number(6)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5)");
    }
    //@Test
    public void should_reduce_chance_one_by_one_when_chance_is_0_game_over() throws IOException {
        game.start();
        inOrder.verify(out).println("welcome");
        inOrder.verify(out).println("Please input your number(6)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(4)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(3)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(2)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(1)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("over");
        inOrder.verify(out,never()).println("0A4B");
    }
    @Test
    public void should_congratulation_when_answer_is_right_first() throws IOException {
        given(red.readLine()).willReturn("4321");
        game.start();
        inOrder.verify(out).println("welcome");
        inOrder.verify(out).println("Please input your number(6)");
        inOrder.verify(out).println("congratulation");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("Please input your number(5)");
    }

    @Test
    public void should_congratulation_when_answer_is_right_second() throws IOException {
        given(red.readLine()).willReturn("1234","4321");
        game.start();
        inOrder.verify(out).println("welcome");
        inOrder.verify(out).println("Please input your number(6)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5)");
        inOrder.verify(out).println("congratulation");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("Please input your number(5)");
    }
    @Test
    public void should_congratulation_when_answer_is_right_last() throws IOException {
        given(red.readLine()).willReturn("1234", "1234", "1234", "1234", "1234", "4321");
        game.start();
        inOrder.verify(out).println("welcome");
        inOrder.verify(out).println("Please input your number(6)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(4)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(3)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(2)");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(1)");
        //inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("congratulation");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("over");
    }
    
  /*  @Test
    public void number6(){
        int number=6;
        Game.gamePlay(number);
        System.out.println("Please input your number("+number+")");
    }
    @Test
    public void number5(){
        int number=5;
        Game.gamePlay(number);
        System.out.println("Please input your number("+number+")");
    }
    @Test
    public void number4(){
        int number=4;
        Game.gamePlay(number);
        System.out.println("Please input your number("+number+")");
    } @Test
      public void number3(){
        int number=3;
        Game.gamePlay(number);
        System.out.println("Please input your number("+number+")");
    } @Test
      public void number2(){
        int number=2;
        Game.gamePlay(number);
        System.out.println("Please input your number("+number+")");
    } @Test
      public void number1(){
        int number=1;
        Game.gamePlay(number);
        System.out.println("Please input your number("+number+")");
    }*/
}
