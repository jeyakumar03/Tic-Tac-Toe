import java.util.Scanner;
class tictactoe
{
   static char[][] board;
   public tictactoe()
   {
         board=new char[3][3];
         initboard();
   }
   void initboard()
   {
       for(int i=0;i<board.length;i++)
       {
          for(int j=0;j<board[i].length;j++)
          {
             board[i][j]=' ';
          }
        }
    }
    static void display()
    {
      System.out.println("---------------");
      for(int i=0;i<board.length;i++)
      {
        System.out.print("| ");
        for(int j=0;j<board[i].length;j++)
        {
           System.out.print(board[i][j]+" |  ");
        }
        System.out.println();
        System.out.println("---------------");
     }
   }
   static void placemark(int row,int column,char mark)
   {
     if(row>=0 && row<=2 && column>=0 && column<=2)
     {
       board[row][column]=mark;
     }
     else
     {
        System.out.println("Invalid input");
     }
   }
  static boolean checkcolwin()
  {
     for(int j=0;j<=2;j++)
     {
     if(board[0][j]!=' ' && board[0][j]==board[1][j] &&board[1][j]==board[2][j])
     {
        return true;
     }

    }
         return false;
  }
   static boolean checkrowwin()
  {
     for(int i=0;i<=2;i++)
     {
        if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
        {
           return true;
        }
      }
    return false;
  }
  static boolean checkdiawin()
  {
     if(board[0][0] !=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] &&board[1][1]==board[2][0])
     {
        return true;
     }
   return false;
  }
 }
     
     
class human
{
   String name;
   char mark;  
   Scanner ob=new Scanner(System.in);
   int row,col;
   
   human(String name,char mark)
   {
      this.name=name;
      this.mark=mark;
   }
   
   void makemove()
   {
    do
    {
      System.out.println("ENter the row and column:");
      row=ob.nextInt();
      col=ob.nextInt();
   }while(!isvalidmove(row,col));
  
   
   tictactoe.placemark(row,col,mark);
   }
   
   boolean isvalidmove(int row,int col)
   {
    if(row>=0 && row<=2 &&col>=0 && col<=2)
    {
       if(tictactoe.board[row][col]==' ')
       {
          return true;
       }
      }
       return false;
    }
  public static void main(String[] args)
  {
     
     tictactoe t=new tictactoe();
     Scanner ob=new Scanner(System.in);
     System.out.println("ENter the first player name:");
     String name1=ob.next();
     System.out.println("Enter the sign for first person:");
     char c1=ob.next().charAt(0);
     System.out.println("ENter the second player name:");
     String name2=ob.next();
     System.out.println("Enter the sign for second person:");
     char c2=ob.next().charAt(0);
     
     human p1=new human(name1,c1);
     human p2=new human(name2,c2);
     human cp;
     cp=p1;
     while(true)
     {
     
     System.out.println(cp.name+"  turn");
     cp.makemove();
     tictactoe.display();
     if(tictactoe.checkcolwin()||tictactoe.checkrowwin()||tictactoe.checkdiawin())
     {
     System.out.println(cp.name+"Has Won");
     break;
     }
     else
     {	
       if(cp==p1)
       {
         cp=p2;
       }
       else
       {
         cp=p1;
       }
     }
   }
     
  }
}


