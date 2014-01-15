public class Intel{
	public static int drawShape(int[][] board, GameFrame mf){
		int y= board[0].length-2;
		int type= (int)(Math.random()*7)+1;
		int x= 0;
		try{
			if(type==1){
				//draw J
				x= (int)(Math.random()*(board.length-2));
				if(board[x][y]>8){
					throw new Exception();
				}
				else if(board[x+1][y]>8){
					throw new Exception();
				}
				else if(board[x+2][y]>8){
					throw new Exception();
				}
				else if(board[x][y+1]>8){
					throw new Exception();
				}
				board[x][y]= 1;
				board[x+1][y]= 1;
				board[x][y+1]= 1;
				board[x+2][y]= 1;
			}
			else if(type==2){
				//draw L
				x= (int)(Math.random()*(board.length-2));
				if(board[x][y]>8){
					throw new Exception();
				}
				else if(board[x][y+1]>8){
					throw new Exception();
				}
				else if(board[x+1][y+1]>8){
					throw new Exception();
				}
				else if(board[x+2][y+1]>8){
					throw new Exception();
				}
				board[x][y+1]= 2;
				board[x][y]= 2;
				board[x+1][y+1]= 2;
				board[x+2][y+1]= 2;
			}
			else if(type==3){
				//draw line
				x= (int)(Math.random()*(board.length-3));
				if(board[x][y]>8){
					throw new Exception();
				}
				else if(board[x+1][y]>8){
					throw new Exception();
				}
				else if(board[x+2][y]>8){
					throw new Exception();
				}
				else if(board[x+3][y]>8){
					throw new Exception();
				}
				board[x][y]= 3;
				board[x+1][y]= 3;
				board[x+2][y]= 3;
				board[x+3][y]= 3;
			}
			else if(type==4){
				//draw S
				x= (int)(Math.random()*(board.length-3));
				if(board[x][y]>8){
					throw new Exception();
				}
				else if(board[x+1][y]>8){
					throw new Exception();
				}
				else if(board[x+1][y+1]>8){
					throw new Exception();
				}
				else if(board[x+2][y+1]>8){
					throw new Exception();
				}
				board[x][y]= 4;
				board[x+1][y]= 4;
				board[x+1][y+1]= 4;
				board[x+2][y+1]= 4;
			}
			else if(type==5){
				//draw Z
				x= (int)(Math.random()*(board.length-3));
				if(board[x][y+1]>8){
					throw new Exception();
				}
				else if(board[x+1][y+1]>8){
					throw new Exception();
				}
				else if(board[x+1][y]>8){
					throw new Exception();
				}
				else if(board[x+2][y]>8){
					throw new Exception();
				}
				board[x][y+1]= 5;
				board[x+1][y+1]= 5;
				board[x+1][y]= 5;
				board[x+2][y]= 5;
			}
			else if(type==6){
				//draw square
				x= (int)(Math.random()*(board.length-1));
				if(board[x][y]>8){
					throw new Exception();
				}
				else if(board[x][y+1]>8){
					throw new Exception();
				}
				else if(board[x+1][y]>8){
					throw new Exception();
				}
				else if(board[x+1][y+1]>8){
					throw new Exception();
				}
				board[x][y]= 6;
				board[x][y+1]= 6;
				board[x+1][y]= 6;
				board[x+1][y+1]= 6;
			}
			else if(type==7){
				//draw T
				x= (int)(Math.random()*(board.length-2));
				if(board[x][y]>8){
					throw new Exception();
				}
				else if(board[x+1][y]>8){
					throw new Exception();
				}
				else if(board[x+2][y]>8){
					throw new Exception();
				}
				else if(board[x+1][y+1]>8){
					throw new Exception();
				}
				board[x][y]= 7;
				board[x+1][y]= 7;
				board[x+2][y]= 7;
				board[x+1][y+1]= 7;
			}
		}catch(Exception e){
			mf.endGame();
		}
		return type;
	}
	public static int[][] rotateShapeCW(int type, int[][] board){
		int counter= 0;
		int[] x= new int[4];
		int[] y= new int[4];
		for(int i= board[0].length-1; i>=0; i--){
			for(int j= 0; j<board.length; j++){
				if(board[j][i]!=0&&board[j][i]<8){
					x[counter]= j;
					y[counter]= i;
					counter++;
				}
			}
		}
		board[x[0]][y[0]]= 0;
		board[x[1]][y[1]]= 0;
		board[x[2]][y[2]]= 0;
		board[x[3]][y[3]]= 0;
		boolean change= false;
		if(type==1){
			if((y[1]==y[2]&&y[2]==y[3])||(y[0]==y[1]&&y[1]==y[2])){
				if(y[0]==y[1]+1){//if |___
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]-1]<8&&board[x[2]][y[2]+1]<8&&board[x[2]+1][y[2]+1]<8){
							board[x[2]][y[2]]= 1;
							board[x[2]][y[2]-1]= 1;
							board[x[2]][y[2]+1]= 1;
							board[x[2]+1][y[2]+1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if ---|
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]+1]<8&&board[x[1]][y[1]-1]<8&&board[x[1]-1][y[1]-1]<8){
							board[x[1]][y[1]]= 1;
							board[x[1]][y[1]+1]= 1;
							board[x[1]][y[1]-1]= 1;
							board[x[1]-1][y[1]-1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
			}
			else{
				if(y[0]>y[1]){//if _|
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]-1][y[1]+1]<8){
							board[x[1]][y[1]]= 1;
							board[x[1]+1][y[1]]= 1;
							board[x[1]-1][y[1]]= 1;
							board[x[1]-1][y[1]+1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if |-
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]-1][y[2]]<8&&board[x[2]+1][y[2]]<8&&board[x[2]+1][y[2]-1]<8){
							board[x[2]][y[2]]= 1;
							board[x[2]-1][y[2]]= 1;
							board[x[2]+1][y[2]]= 1;
							board[x[2]+1][y[2]-1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
			}
		}
		else if(type==2){
			if((y[0]==y[1]&&y[1]==y[2])||(y[1]==y[2]&&y[2]==y[3])){
				if(y[0]!=y[1]){//if ___|
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]-1]<8&&board[x[2]][y[2]+1]<8&&board[x[2]+1][y[2]-1]<8){
							board[x[2]][y[2]]= 2;
							board[x[2]][y[2]-1]= 2;
							board[x[2]][y[2]+1]= 2;
							board[x[2]+1][y[2]-1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if |---
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]-1]<8&&board[x[1]][y[1]+1]<8&&board[x[1]-1][y[1]+1]<8){
							board[x[1]][y[1]]= 2;
							board[x[1]][y[1]-1]= 2;
							board[x[1]][y[1]+1]= 2;
							board[x[1]-1][y[1]+1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
			}
			else{
				if(x[0]==x[1]&&x[1]==x[2]){//if |_
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]-1][y[1]-1]<8){
							board[x[1]][y[1]]= 2;
							board[x[1]+1][y[1]]= 2;
							board[x[1]-1][y[1]]= 2;
							board[x[1]-1][y[1]-1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if -|
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]+1][y[1]+1]<8){
							board[x[1]][y[1]]= 2;
							board[x[1]-1][y[1]]= 2;
							board[x[1]+1][y[1]]= 2;
							board[x[1]+1][y[1]+1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
			}
		}
		else if(type==3){
			if(y[0]==y[1]){//if -
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]][y[1]+1]<8&&board[x[1]][y[1]-1]<8&&board[x[1]][y[1]-2]<8){
						board[x[1]][y[1]]= 3;
						board[x[1]][y[1]+1]= 3;
						board[x[1]][y[1]-1]= 3;
						board[x[1]][y[1]-2]= 3;
						change= true;
					}
				}catch(Exception e){}
			}
			else{//if |
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]+2][y[1]]<8){
						board[x[1]][y[1]]= 3;
						board[x[1]-1][y[1]]= 3;
						board[x[1]+1][y[1]]= 3;
						board[x[1]+2][y[1]]= 3;
						change= true;
					}
				}catch(Exception e){}
			}
		}
		else if(type==4){//if S
			if(y[0]==y[1]){//if _-
				try{
					if(board[x[3]][y[3]]<8&&board[x[3]][y[3]+1]<8&&board[x[3]+1][y[3]]<8&&board[x[3]+1][y[3]-1]<8){
						board[x[3]][y[3]]= 4;
						board[x[3]][y[3]+1]= 4;
						board[x[3]+1][y[3]]= 4;
						board[x[3]+1][y[3]-1]= 4;
						change= true;
					}
				}catch(Exception e){}
			}
			else{//if ||
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]][y[1]+1]<8&&board[x[1]+1][y[1]+1]<8){
						board[x[1]][y[1]]= 4;
						board[x[1]-1][y[1]]= 4;
						board[x[1]][y[1]+1]= 4;
						board[x[1]+1][y[1]+1]= 4;
						change= true;
					}
				}catch(Exception e){}
			}
		}
		else if(type==5){//if Z
			if(y[0]==y[1]){//if -_
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]][y[1]+1]<8&&board[x[1]-1][y[1]]<8&&board[x[1]-1][y[1]-1]<8){
						board[x[1]][y[1]]= 5;
						board[x[1]][y[1]+1]= 5;
						board[x[1]-1][y[1]]= 5;
						board[x[1]-1][y[1]-1]= 5;
						change= true;
					}
				}catch(Exception e){}
			}
			else{//if ||
				try{
					if(board[x[2]][y[2]]<8&&board[x[2]+1][y[2]]<8&&board[x[2]][y[2]+1]<8&&board[x[2]-1][y[2]+1]<8){
						board[x[2]][y[2]]= 5;
						board[x[2]+1][y[2]]= 5;
						board[x[2]][y[2]+1]= 5;
						board[x[2]-1][y[2]+1]= 5;
						change= true;
					}
				}catch(Exception e){}
			}
		}
		else if(type==7){
			if((y[0]==y[1]&&y[1]==y[2])||(y[1]==y[2]&&y[2]==y[3])){
				if(y[0]!=y[1]){//if _|_
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]+1]<8&&board[x[2]][y[2]-1]<8&&board[x[2]+1][y[2]]<8){
							board[x[2]][y[2]]= 7;
							board[x[2]][y[2]+1]= 7;
							board[x[2]][y[2]-1]= 7;
							board[x[2]+1][y[2]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if -|-
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]+1]<8&&board[x[1]][y[1]-1]<8&&board[x[1]-1][y[1]]<8){
							board[x[1]][y[1]]= 7;
							board[x[1]][y[1]+1]= 7;
							board[x[1]][y[1]-1]= 7;
							board[x[1]-1][y[1]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
			}
			else{
				if(x[0]<x[2]){//if |-
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]-1]<8&&board[x[1]-1][y[1]]<8&&board[x[1]+1][y[1]]<8){
							board[x[1]][y[1]]= 7;
							board[x[1]][y[1]-1]= 7;
							board[x[1]-1][y[1]]= 7;
							board[x[1]+1][y[1]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if -|
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]+1]<8&&board[x[2]-1][y[2]]<8&&board[x[2]+1][y[2]]<8){
							board[x[2]][y[2]]= 7;
							board[x[2]][y[2]+1]= 7;
							board[x[2]-1][y[2]]= 7;
							board[x[2]+1][y[2]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
			}
		}
		if(!change){
			board[x[0]][y[0]]= type;
			board[x[1]][y[1]]= type;
			board[x[2]][y[2]]= type;
			board[x[3]][y[3]]= type;
		}
		return board;
	}
	public static int[][] rotateShapeCCW(int type, int[][] board){
		int counter= 0;
		int[] x= new int[4];
		int[] y= new int[4];
		for(int i= board[0].length-1; i>=0; i--){
			for(int j= 0; j<board.length; j++){
				if(board[j][i]!=0&&board[j][i]<8){
					x[counter]= j;
					y[counter]= i;
					counter++;
				}
			}
		}
		board[x[0]][y[0]]= 0;
		board[x[1]][y[1]]= 0;
		board[x[2]][y[2]]= 0;
		board[x[3]][y[3]]= 0;
		boolean change= false;
		if(type==1){
			if((y[1]==y[2]&&y[2]==y[3])||(y[0]==y[1]&&y[1]==y[2])){
				if(y[0]==y[1]+1){//if |___
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]+1]<8&&board[x[2]][y[2]-1]<8&&board[x[2]-1][y[2]-1]<8){
							board[x[2]][y[2]]= 1;
							board[x[2]][y[2]+1]= 1;
							board[x[2]][y[2]-1]= 1;
							board[x[2]-1][y[2]-1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if ---|
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]-1]<8&&board[x[1]][y[1]+1]<8&&board[x[1]+1][y[1]+1]<8){
							board[x[1]][y[1]]= 1;
							board[x[1]][y[1]-1]= 1;
							board[x[1]][y[1]+1]= 1;
							board[x[1]+1][y[1]+1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
			}
			else{
				if(y[0]>y[1]){//if _|
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]+1][y[1]-1]<8){
							board[x[1]][y[1]]= 1;
							board[x[1]-1][y[1]]= 1;
							board[x[1]+1][y[1]]= 1;
							board[x[1]+1][y[1]-1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if |-
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]+1][y[2]]<8&&board[x[2]-1][y[2]]<8&&board[x[2]-1][y[2]+1]<8){
							board[x[2]][y[2]]= 1;
							board[x[2]+1][y[2]]= 1;
							board[x[2]-1][y[2]]= 1;
							board[x[2]-1][y[2]+1]= 1;
							change= true;
						}
					}catch(Exception e){}
				}
			}
		}
		else if(type==2){
			if((y[0]==y[1]&&y[1]==y[2])||(y[1]==y[2]&&y[2]==y[3])){
				if(y[0]!=y[1]){//if ___|
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]+1]<8&&board[x[2]][y[2]-1]<8&&board[x[2]-1][y[2]+1]<8){
							board[x[2]][y[2]]= 2;
							board[x[2]][y[2]+1]= 2;
							board[x[2]][y[2]-1]= 2;
							board[x[2]-1][y[2]+1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if |---
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]+1]<8&&board[x[1]][y[1]-1]<8&&board[x[1]+1][y[1]-1]<8){
							board[x[1]][y[1]]= 2;
							board[x[1]][y[1]+1]= 2;
							board[x[1]][y[1]-1]= 2;
							board[x[1]+1][y[1]-1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
			}
			else{
				if(x[0]==x[1]&&x[1]==x[2]){//if |_
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]+1][y[1]+1]<8){
							board[x[1]][y[1]]= 2;
							board[x[1]-1][y[1]]= 2;
							board[x[1]+1][y[1]]= 2;
							board[x[1]+1][y[1]+1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if -|
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]-1][y[1]-1]<8){
							board[x[1]][y[1]]= 2;
							board[x[1]+1][y[1]]= 2;
							board[x[1]-1][y[1]]= 2;
							board[x[1]-1][y[1]-1]= 2;
							change= true;
						}
					}catch(Exception e){}
				}
			}
		}
		else if(type==3){
			if(y[0]==y[1]){//if -
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]][y[1]-1]<8&&board[x[1]][y[1]+1]<8&&board[x[1]][y[1]+2]<8){
						board[x[1]][y[1]]= 3;
						board[x[1]][y[1]-1]= 3;
						board[x[1]][y[1]+1]= 3;
						board[x[1]][y[1]+2]= 3;
						change= true;
					}
				}catch(Exception e){}
			}
			else{//if |
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]-1][y[1]]<8&&board[x[1]-2][y[1]]<8){
						board[x[1]][y[1]]= 3;
						board[x[1]+1][y[1]]= 3;
						board[x[1]-1][y[1]]= 3;
						board[x[1]-2][y[1]]= 3;
						change= true;
					}
				}catch(Exception e){}
			}
		}
		else if(type==4){//if S
			if(y[0]==y[1]){//if _-
				try{
					if(board[x[3]][y[3]]<8&&board[x[3]][y[3]-1]<8&&board[x[3]-1][y[3]]<8&&board[x[3]-1][y[3]+1]<8){
						board[x[3]][y[3]]= 4;
						board[x[3]][y[3]-1]= 4;
						board[x[3]-1][y[3]]= 4;
						board[x[3]-1][y[3]+1]= 4;
						change= true;
					}
				}catch(Exception e){}
			}
			else{//if ||
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]+1][y[1]]<8&&board[x[1]][y[1]-1]<8&&board[x[1]-1][y[1]-1]<8){
						board[x[1]][y[1]]= 4;
						board[x[1]+1][y[1]]= 4;
						board[x[1]][y[1]-1]= 4;
						board[x[1]-1][y[1]-1]= 4;
						change= true;
					}
				}catch(Exception e){}
			}
		}
		else if(type==5){//if Z
			if(y[0]==y[1]){//if -_
				try{
					if(board[x[1]][y[1]]<8&&board[x[1]][y[1]-1]<8&&board[x[1]+1][y[1]]<8&&board[x[1]+1][y[1]+1]<8){
						board[x[1]][y[1]]= 5;
						board[x[1]][y[1]-1]= 5;
						board[x[1]+1][y[1]]= 5;
						board[x[1]+1][y[1]+1]= 5;
						change= true;
					}
				}catch(Exception e){}
			}
			else{//if ||
				try{
					if(board[x[2]][y[2]]<8&&board[x[2]-1][y[2]]<8&&board[x[2]][y[2]-1]<8&&board[x[2]+1][y[2]-1]<8){
						board[x[2]][y[2]]= 5;
						board[x[2]-1][y[2]]= 5;
						board[x[2]][y[2]-1]= 5;
						board[x[2]+1][y[2]-1]= 5;
						change= true;
					}
				}catch(Exception e){}
			}
		}
		else if(type==7){
			if((y[0]==y[1]&&y[1]==y[2])||(y[1]==y[2]&&y[2]==y[3])){
				if(y[0]!=y[1]){//if _|_
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]-1]<8&&board[x[2]][y[2]+1]<8&&board[x[2]-1][y[2]]<8){
							board[x[2]][y[2]]= 7;
							board[x[2]][y[2]-1]= 7;
							board[x[2]][y[2]+1]= 7;
							board[x[2]-1][y[2]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if -|-
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]-1]<8&&board[x[1]][y[1]+1]<8&&board[x[1]+1][y[1]]<8){
							board[x[1]][y[1]]= 7;
							board[x[1]][y[1]-1]= 7;
							board[x[1]][y[1]+1]= 7;
							board[x[1]+1][y[1]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
			}
			else{
				if(x[0]<x[2]){//if |-
					try{
						if(board[x[1]][y[1]]<8&&board[x[1]][y[1]+1]<8&&board[x[1]+1][y[1]]<8&&board[x[1]-1][y[1]]<8){
							board[x[1]][y[1]]= 7;
							board[x[1]][y[1]+1]= 7;
							board[x[1]+1][y[1]]= 7;
							board[x[1]-1][y[1]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
				else{//if -|
					try{
						if(board[x[2]][y[2]]<8&&board[x[2]][y[2]-1]<8&&board[x[2]+1][y[2]]<8&&board[x[2]-1][y[2]]<8){
							board[x[2]][y[2]]= 7;
							board[x[2]][y[2]-1]= 7;
							board[x[2]+1][y[2]]= 7;
							board[x[2]-1][y[2]]= 7;
							change= true;
						}
					}catch(Exception e){}
				}
			}
		}
		if(!change){
			board[x[0]][y[0]]= type;
			board[x[1]][y[1]]= type;
			board[x[2]][y[2]]= type;
			board[x[3]][y[3]]= type;
		}
		return board;
	}
	public static int[][] move(int[][] board, int direction){
		int counter= 0;
		int[] x= new int[4];
		int[] y= new int[4];
		for(int i= board[0].length-1; i>=0; i--){
			for(int j= 0; j<board.length; j++){
				if(board[j][i]!=0&&board[j][i]<8){
					x[counter]= j;
					y[counter]= i;
					counter++;
				}
			}
		}
		if(direction==0){
			try{
				if(board[x[0]+1][y[0]]<8&&board[x[1]+1][y[1]]<8&&board[x[2]+1][y[2]]<8&&board[x[3]+1][y[3]]<8){
					int type= board[x[0]][y[0]];
					board[x[0]][y[0]]= 0;
					board[x[1]][y[1]]= 0;
					board[x[2]][y[2]]= 0;
					board[x[3]][y[3]]= 0;
					board[x[0]+1][y[0]]= type;
					board[x[1]+1][y[1]]= type;
					board[x[2]+1][y[2]]= type;
					board[x[3]+1][y[3]]= type;

				}
			}catch(Exception e){}
		}
		else if(direction==1){
			try{
				if(board[x[0]-1][y[0]]<8&&board[x[1]-1][y[1]]<8&&board[x[2]-1][y[2]]<8&&board[x[3]-1][y[3]]<8){
					int type= board[x[0]][y[0]];
					board[x[0]][y[0]]= 0;
					board[x[1]][y[1]]= 0;
					board[x[2]][y[2]]= 0;
					board[x[3]][y[3]]= 0;
					board[x[0]-1][y[0]]= type;
					board[x[1]-1][y[1]]= type;
					board[x[2]-1][y[2]]= type;
					board[x[3]-1][y[3]]= type;
				}
			}catch(Exception e){}
		}
		else if(direction==2){
			try{
				for(int i= 0; i<board[0].length; i++){
					for(int j= 0; j<board.length; j++){
						if(board[j][i]!=0&&board[j][i]<8){
							board[j][i-1]= board[j][i];
							board[j][i]= 0;
						}
					}
				}
			}catch(Exception e){}
		}
		return board;
	}
}
