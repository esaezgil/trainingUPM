package BattleFight;
import upm.jbb.IO;

public class View {
	
	public View (){
		IO.out.print("View created"); 
	}
	
	public void showHorizontalLine(Board board){
		IO.out.print("\n");	
		for(int i =0; i < 3*board.getCols() + 2; i++){			
			IO.out.print("--");			
		}
	}
	
	private void paint(String aux){
		IO.out.print(aux);
	}
	
	public void showShips(Board board){
		showHorizontalLine(board);
		for(int i = 0; i < board.getRows(); i++){
			this.paint("\n|");
			for(int j = 0; j < board.getCols(); j++){
				if(board.getBoard().get( board.getCols()*i + j).getContent() == Result.HARM){
					paint("  H   |");
				}
				else if(board.getBoard().get( board.getCols()*i + j).getContent() == Result.SUNK){
					paint("  S   |");
				}				
				else if(board.getBoard().get( board.getCols()*i + j).getContent() == Result.MISSED){
					paint("  M    |");
				}
				else this.paint("        |");
				}
		}
	showHorizontalLine(board);
	}
}
