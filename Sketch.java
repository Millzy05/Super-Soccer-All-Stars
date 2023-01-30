import processing.core.PApplet;
import java.lang.Math;
import java.util.Arrays;

public class Sketch extends PApplet {

  //initialisation
  final int WIDTH = 1000;
  final int HEIGHT = 600;

  //button coords
  int quitX = 450;
  int quitY = 445;
  int quitW = 100;
  int quitH = 40;
  int startX = 365;
  int startY = 215;
  int startW = 260;
  int startH = 40;
  int controlsX = 385;
  int controlsY = 335;
  int controlsW = 225;
  int controlsH = 40;
  int backX = 15;
  int backY = 470;
  int backW = 125;
  int backH = 75;
  int playerSpeed = 2;
  int com1Speed = 1;
  double com2Speed = 1.5;
  //player variables initilisation
  int player1X = 200;
  int player1Y = 300;
  int player2X = 200;
  int player2Y = 500;
  int scorePlayer = 0;
  //COMputer variables initilisation
  int com1X = 770;
  int com1Y = 300;
  float com2X = 770;
  float com2Y = 500;
  int scoreCom = 0;
  //ball stuff
  float ballX = (WIDTH-250) /2 +125;
  float ballY = (HEIGHT-125)/2+125 ;

  //what keys are pressed int
  boolean[] keys;
  //where is the ball
  boolean[] playerWithBall;
  //direction of kick
  boolean[] directionOfKick;


  //int teams
  
  
  //screen int
  boolean titleScreen = true;

  boolean gameScreen = false;
 
  boolean gameOverScreen = false;
  boolean controlScreen = false;
  
  
  
  public void settings() {
    playerWithBall = new boolean[5];
    directionOfKick= new boolean[4];
    
    keys = new boolean[12];
    keys[0] = false;
    keys[1] = false;
    keys[2] = false;
    keys[3] = false;
    keys[4] = false;
    keys[5] = false;
    keys[6] = false;
    keys[7] = false;
    keys[8] = false;
    keys[9] = false;
    keys[10] = false;
    keys[11] = false;
    playerWithBall[0] = false;
    playerWithBall[1] = false;
    playerWithBall[2] = false;
    playerWithBall[3] = false;
    playerWithBall[4] = true;
    directionOfKick[0] = false;
    directionOfKick[1] = false;
    directionOfKick[2] = false;
    directionOfKick[3] = false;
    
    size(WIDTH , HEIGHT);
  }
  public void keyPressed(){
      if (key=='w')
        keys[0]=true;
      if (key=='a')
        keys[1]=true;
      if (key=='s')
        keys[2]=true;
      if (key=='d')
        keys[3]=true;
      if (keyCode==UP)
        keys[4]=true;
      if (keyCode==LEFT)
        keys[5]=true;
      if (keyCode==DOWN)
        keys[6]=true;
      if (keyCode==RIGHT)
        keys[7]=true;
      if(key == 'q')
        keys[8] = true;
      if(key == '/')
        keys[9] = true;
      if(key=='1')
        keys[10]=true;
      if(key == '.')
        keys[11] = true;
    }
  public void keyReleased()  {
      //Player 1
      if (key=='w')
         keys[0]=false;
      if (key=='a')
         keys[1]=false;
      if (key=='s')
         keys[2]=false;
      if (key=='d')
         keys[3]=false;
      if(key == 'q')
        keys[8] =false;
      //Player 2
      if (keyCode==UP)
        keys[4]=false;
      if (keyCode==LEFT)
        keys[5]=false;
      if (keyCode==DOWN)
        keys[6]=false;
      if (keyCode==RIGHT)
        keys[7]=false;
      if (key=='/')
        keys[9] = false;
      if(key=='1')
        keys[10] = false;
      if(key=='.')
        keys[11]=false;
   } 
  

  public void draw() {
    
    //title screen
    if(titleScreen){
      image(loadImage("TITLESCREEN.jpg"),0,0);
      

      //Black letters
      fill(0,0,0);
      textSize(60);
      textAlign(CENTER);
      text("SUPER SOCCER ALL STARS", (WIDTH/2) - 7,100);
      textSize(40);
      text("START GAME", (WIDTH/2)-6,(HEIGHT/3)+50);
      text("CONTROLS", (WIDTH/2)-6, (HEIGHT/3)*2-30);
      text("QUIT",(WIDTH/2)-6, (HEIGHT/3)*2+80);

      //White letters
      fill(255,255,255);
      textSize(60);
      textAlign(CENTER);
      text("SUPER SOCCER ALL STARS", (WIDTH/2),100);
      textSize(40);
      if(mouseX>startX && mouseX<startX+startW && mouseY>startY && mouseY<startY+startH){
        fill(0,0,255);
      }
      text("START GAME", (WIDTH/2),(HEIGHT/3)+50);
      fill(255,255,255);
      if(mouseX>controlsX && mouseX<controlsX+controlsW && mouseY>controlsY && mouseY<controlsY+controlsH){
        fill(0,0,255);
      }
      text("CONTROLS", WIDTH/2, (HEIGHT/3)*2-30);
      fill(255,255,255);
      if(mouseX>quitX && mouseX<quitX+quitW && mouseY>quitY && mouseY<quitY+quitH){
        fill(0,0,255);
      }
      text("QUIT",(WIDTH/2), (HEIGHT/3)*2+80);
      fill(255,255,255);
      textSize(12);
      textAlign(LEFT);
      text("BY KYLER MONTERROSO AND DENVER MILLS", (WIDTH/2) + 200,HEIGHT - 30);

      //click on main screen
      if(mousePressed){
        //inside quit area
        if(mouseX>quitX && mouseX<quitX+quitW && mouseY>quitY && mouseY<quitY+quitH){

          exit();
        }
        //inside play game area
        if(mouseX>startX && mouseX<startX+startW && mouseY>startY && mouseY<startY+startH){
          scorePlayer = 0;
          scoreCom = 0;
          player1X = 200;
           player1Y = 300;
            player2X = 200;
           player2Y = 500;
             com1X = 770;
            com1Y = 300;
             com2X = 770;
             com2Y = 500;
          titleScreen = false;
      
          gameScreen =true;
          
        }
        //inside controls area
        if(mouseX>controlsX && mouseX<controlsX+controlsW && mouseY>controlsY && mouseY<controlsY+controlsH){
          controlScreen = true;
          titleScreen = false;
         
          
        }
      }





      //gamescreen
    }else if(gameScreen){
      
      background(152, 190, 100);
      //stands
      fill(255,0,0);
      rect(0,0,WIDTH,125);
      fill(255,255,255);
      textSize(50);
      textAlign(CENTER);
      text("HOME: "+scorePlayer+" AWAY: "+scoreCom, (WIDTH/2),50);
      //nets
      fill(100,100,100);
      rect(0,125,75,475);
      rect(WIDTH-75,125,75,475);
      fill(255,255,255);
      rect(50,312,25,100);
      rect(WIDTH-75,312,25,100);
      
     
      //track player movement
    
      //player1 movement
      if(keys[0]){  
        if(player1Y>=98){
          player1Y -= playerSpeed;
        }
      }
      if(keys[1]){
        if(player1X>=78){
          player1X-= playerSpeed;
        }
      }
      if(keys[2]){
        if(player1Y <= 537){
          player1Y += playerSpeed;
        }
      }
      if(keys[3]){
        if(player1X <=892){
          player1X +=playerSpeed;
        }
      }
			
			//player 2 movement
			if(keys[4]){
				if(player2Y>=98){
					player2Y -= playerSpeed;
				}         
			}
			if(keys[5]){
				if(player2X>=78){
					player2X-= playerSpeed;
				}
			}
			if(keys[6]){
				if(player2Y <= 537){
					player2Y += playerSpeed;

				}
			}
			if(keys[7]){
				if(player2X <=892){
					player2X += playerSpeed;
				}
			}
      //ai 
      if(playerWithBall[2]!= true && playerWithBall[3] != true){
        if(ballX-15>com1X){
          com1X += com1Speed;
        }
        if(ballX-15<com1X){
          com1X -= com1Speed;
        }
        if(ballY-45>com1Y){
          com1Y += com1Speed;
        }
        if(ballY-45<com1Y){
          com1Y -= com1Speed;
        }
        if(ballX-15>com2X){
          com2X += com2Speed;
        }
        if(ballX-15<com2X){
          com2X -= com2Speed;
        }
        if(ballY-45>com2Y){
          com2Y += com2Speed;
        }
        if(ballY-45<com2Y){
          com2Y -= com2Speed;
        }
      }
      
      
      //ball movement
      //player 1
      if(playerWithBall[0]==true){
        directionOfKick[0]=false;
        directionOfKick[1]=false;
        directionOfKick[2]=false;
        directionOfKick[3]=false;
        ballX = player1X+15;
        ballY = player1Y+45;
        if(keys[8]){
            
          if(keys[0]){
            directionOfKick[3] =true;
            playerWithBall[0]=false;
            playerWithBall[4] = true;
          }
          if(keys[1]){
            directionOfKick[2] =true;
            playerWithBall[0]=false;
            playerWithBall[4] = true;
          }
          if(keys[2]){
            directionOfKick[1] =true;
            playerWithBall[0]=false;
            playerWithBall[4] = true;
          }
          if(keys[3]){
            directionOfKick[0] =true;
            playerWithBall[0]=false;
            playerWithBall[4] = true;
          }
        }
        
        //player 2
      }else if(playerWithBall[1]==true){
        directionOfKick[0]=false;
        directionOfKick[1]=false;
        directionOfKick[2]=false;
        directionOfKick[3]=false;
        ballX = player2X+15;
        ballY = player2Y+45;
        if(keys[9]){
          
          if(keys[4]){
            directionOfKick[3] =true;
            playerWithBall[1]=false;
            playerWithBall[4] = true;
          }
          if(keys[5]){
            directionOfKick[2] =true;
            playerWithBall[1]=false;
            playerWithBall[4] = true;
          }
          if(keys[6]){
            directionOfKick[1] =true;
            playerWithBall[1]=false;
            playerWithBall[4] = true;
          }
          if(keys[7]){
            directionOfKick[0] =true;
            playerWithBall[1]=false;
            playerWithBall[4] = true;
          }
        }
        //ai one
      }else if(playerWithBall[2]==true){
        directionOfKick[0]=false;
        directionOfKick[1]=false;
        directionOfKick[2]=false;
        directionOfKick[3]=false;
        ballX = com1X+15;
        ballY = com1Y+45;
        if(com1Y>325){
          com1Y -= 2;
        }
        else if(com1Y<310){
          com1Y += 2;
        }
        else{
          playerWithBall[2] = false;

          playerWithBall[4] = true;
          directionOfKick[2]= true;
          
        }
        
        
        //ai two
      }else if(playerWithBall[3]==true){
        directionOfKick[0]=false;
        directionOfKick[1]=false;
        directionOfKick[2]=false;
        directionOfKick[3]=false;
        ballX = com2X+15;
        ballY = com2Y+45;
        if(com2Y>325){
          com2Y -= 2.5;
        }
        else if(com2Y<310){
          com2Y += 2.5;
        }
        else{
          playerWithBall[3] = false;

          playerWithBall[4] = true;
          directionOfKick[2]= true;
          
        }
        

        
        //no one has ball
      }else if(playerWithBall[4]==true){
        

        if (ballY>143 && ballY<582){
          
          if(directionOfKick[1]==true){
            ballY += 3;
          }
          if(directionOfKick[3]==true){
            ballY -= 3;
          }
        }else{
          
          directionOfKick[1] = false;
          directionOfKick[3] = false;
        }
        
        if(ballX>93 && ballX<907)  {
          if(directionOfKick[0]==true){
            ballX+=3;
          }
          if(directionOfKick[2]==true){
            ballX-=3;
          }
          
        }else{
          if(ballY>312 && ballY<412){
            if(directionOfKick[0]==true){
              scorePlayer += 1;
              ballX = (WIDTH)/2;
              ballY = (HEIGHT)/2 +62;
              player1X = 200;
              player1Y = 300;
              player2X = 200;
              player2Y = 500;
               
              //COMputer variables initilisation
              com1X = 770;
              com1Y = 300;
              com2X = 770;
              com2Y = 500;
              directionOfKick[1] = false;
              directionOfKick[3] = false;
              
            }
            if(directionOfKick[2]==true){
              scoreCom += 1;
              ballX = (WIDTH)/2;
              ballY = (HEIGHT)/2 +62;
              player1X = 200;
              player1Y = 300;
              player2X = 200;
              player2Y = 500;
   
                //COMputer variables initilisation
              com1X = 770;
              com1Y = 300;
              com2X = 770;
              com2Y = 500;
              directionOfKick[1] = false;
              directionOfKick[3] = false;
              
            }
          }
          if(directionOfKick[0]==true){
            directionOfKick[0] = false;
            directionOfKick[2] = false;
           
          }
          if(directionOfKick[2] == true){
            directionOfKick[0] = false;
            directionOfKick[2] = false;
            
          }
         
          
        }

      }

      if(scorePlayer == 3 || scoreCom == 3){
        gameOverScreen = true;
        gameScreen = false;
      }

          
      if(keys[10]){
        if(player1X-15<=ballX && player1X+45>=ballX && player1Y-15<= ballY && player1Y+75>= ballY){
          playerWithBall[0]=true;
          playerWithBall[1]=false;
          playerWithBall[2]=false;
          playerWithBall[3]=false;
          playerWithBall[4]=false;

        }
      }
      if(keys[11]){
        if(player2X-15<=ballX && player2X+45>=ballX && player2Y-15<= ballY && player2Y+75>= ballY){
          playerWithBall[0]=false;
          playerWithBall[1]=true;
          playerWithBall[2]=false;
          playerWithBall[3]=false;
          playerWithBall[4]=false;
        }  
      }
         
    if(com1X-15<=ballX && com1X+45>=ballX && com1Y-15<= ballY && com1Y+75>= ballY){
      float com1Chance = (random(75));
      int com1ChanceInt = Math.round(com1Chance);
      if(com1ChanceInt == 1){
        playerWithBall[0]=false;
        playerWithBall[1]=false;
        playerWithBall[2]=true;
        playerWithBall[3]=false;
        playerWithBall[4]=false;}

      }       
    if(com2X-15<=ballX && com2X+45>=ballX && com2Y-15<= ballY && com2Y+75>= ballY){
      float com2Chance = (random(75));
      int com2ChanceInt = Math.round(com2Chance);
      if(com2ChanceInt == 1){
        playerWithBall[0]=false;
        playerWithBall[1]=false;
        playerWithBall[2]=false;
        playerWithBall[3]=true;
        playerWithBall[4]=false;
      } 
    }
      

//drwing the stuff onto the screen
      playerColour = [0,0,0];
      
      
      fill(playerColour[0],playerColour[1],playerColour[2]);
      
      //player1
      rect(player1X, player1Y,30,60);
      fill(255,0,255);
      rect(player1X, player1Y,30,5);
      //player2
      
      fill(playerColour[0],playerColour[1],playerColour[2]);
      rect(player2X, player2Y,30,60);
      fill(255,165,0);
      rect(player2X,player2Y,30,5);


      
      //draw the computer
      comColour = [255,0,255];
      fill(comColour[0],comColour[1],comColour[2]);
      //player1
      rect(com1X, com1Y,30,60);
      fill(192,192,192);
      rect(com1X, com1Y,30,5);
      //player2
      fill(comColour[0],comColour[1],comColour[2]);
      rect(com2X, com2Y,30,60);
      fill(0,0,0);
      rect(com2X,com2Y,30,5);
      //ball
      fill(255,255,255);
      ellipse(ballX,ballY,30,30);


     


      
      //control screen
    }else if(gameOverScreen){
      
        image(loadImage("TITLESCREEN.jpg"),0,0);
      image(loadImage("BACKBUTTON.png"),15,470);
      if(mousePressed){
        //inside back area
        if(mouseX>backX && mouseX<backX+backW && mouseY>backY && mouseY<backY+backH){
          controlScreen = false;
  titleScreen = true;
          
        }
      }
      if(scorePlayer == 3){
        fill(0,0,0);
        rect(200,150,400,300);
        fill(0,0,255);
        textSize(125);
        text("YOU",375,300);
        text("WIN!",375,400);
        image(loadImage("trophy-removebg-preview.png"),600,100);
      }
      else{
        fill(0,0,0);
        rect(200,150,400,300);
        fill(0,0,255);
        textSize(125);
        text("YOU",375,300);
        text("LOSE",375,400);
        image(loadImage("baby.png"),600,0);
      }
      


      
    }
    
    else if(controlScreen){
     
      background(69,69,69);
      image(loadImage("BACKBUTTON.png"),15,470);
      fill(100,100,255);
      textSize(30);
      text("You and your friend are on the same team.\nPlayer1(blue) uses WASD to move, 'q' to kick the \n ball,and '1' to tackle and collect the ball. Player2(orange) uses \n arrow keys to move, '/' to kick, and '.' to tackle and collect the\n ball",10,200);
      
      if(mousePressed){
        //inside back area
        if(mouseX>backX && mouseX<backX+backW && mouseY>backY && mouseY<backY+backH){
          controlScreen = false;
  titleScreen = true;
          
        }
      }
    }
  }
}
