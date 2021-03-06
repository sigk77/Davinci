import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class MainForm extends JFrame implements ActionListener { // ActionLister 인터페이스
	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	GameRoom gr = new GameRoom();
	Avatar ava = new Avatar();
	CardLayout card = new CardLayout();
	
	MainForm() {
		this.setTitle("The Da Vinci Code Game"); // 타이틀에 게임제목 노출
		setLayout(card);
		add("GAME", gr);
		add("LOGIN", login);
		add("WR", wr);
				
		add("AVARTAR", ava);

		setSize(1024, 768); // 윈도우창 사이즈 설정
		setVisible(true); // 윈도우를 보여라.
		setResizable(false); // 창 크기 변경 불가능하게
		setLocationRelativeTo(null); // 창이 정 중앙에 뜨게 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료 시 게임 종료되도록 (그렇지 않으면 게임 꺼도 계속 돌아감...)
		
		login.b1.addActionListener(this);
		wr.btn_ready_1.addActionListener(this);
		ava.b5.addActionListener(this);

	}

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
		}
		MainForm mf = new MainForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == login.b1) {
			card.show(getContentPane(), "AVARTAR");
		}
		if (e.getSource() == ava.b5) {
			card.show(getContentPane(), "WR");
		}
		if (e.getSource() == wr.btn_ready_1) {
			card.show(getContentPane(), "GAME");
		}

	}
}
