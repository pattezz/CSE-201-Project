import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
  
import javax.swing.JFrame;  
import javax.swing.JMenu;  
import javax.swing.JMenuBar;  
import javax.swing.JMenuItem;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
  
/** 
 *  
 * @author sky 
 * 
 */  
public class FiveChessGame {  
    /** 
     * 控件属性 
     */  
    private JFrame frame; // 五子棋游戏的窗口框架  
    private GameMap map; // 五子棋游戏的窗口容器  
    private JMenuBar bar; // 菜单  
    private JMenu game; // 菜单项  
    private JMenuItem[] items; // 菜单下拉项  
  
    /** 
     * 静态数据属性 
     */  
    private static final int BOARD_SIZE = 15; // 棋盘大小(15 * 15)  
    private static final int ROW_WIDTH = 36; // 间距  
    private static final int SPACE = ROW_WIDTH / 2; // 上下边间距  
  
    /** 
     * 数据属性 
     */  
    private boolean player; // true黑,false白  
    private char[][] board; // 后台虚拟棋盘  
  
    public FiveChessGame() {  
        player = true; // 游戏先黑子下  
        board = new char[BOARD_SIZE][BOARD_SIZE]; // 建立后台虚拟棋盘  
        clearMap();  
        createGUI();  
    }  
  
    /** 
     * 对GUI控件的创建 
     */  
    private void createGUI() {  
        frame = new JFrame("五子棋"); // 实现五子棋游戏窗口框架  
        map = new GameMap(); // 实现五子棋游戏窗口容器  
        bar = new JMenuBar(); // 建立菜单栏  
        game = new JMenu("游戏"); // 建立名为“游戏”的菜单  
        items = new JMenuItem[2]; // game菜单下创建2个子菜单项  
        game.add(items[0] = new JMenuItem("重新开始"));// 第一个子菜单为“重新开始”  
        game.add(items[1] = new JMenuItem("退出")); // 第二个子菜单为“退出”  
    }  
  
    /** 
     * 清空棋子 
     */  
    protected void clearMap() {  
        for (int i = 0; i < BOARD_SIZE; i++) {  
            for (int j = 0; j < BOARD_SIZE; j++) {  
                board[i][j] = '+';  
            }  
        }  
    }  
  
    /** 
     * 运行游戏 
     */  
    public void start() {  
        map.setPreferredSize(new Dimension(ROW_WIDTH * (BOARD_SIZE - 1) + SPACE  
                * 2, ROW_WIDTH * (BOARD_SIZE - 1) + SPACE * 2));  
        map.addMouseListener(new MouseAdapter() {  
            // 鼠标点击事件  
            public void mouseClicked(MouseEvent e) {  
                // 将用户鼠标事件的座标转换成棋子数组的座标。  
                int xPos = (int) (e.getX() / ROW_WIDTH);  
                int yPos = (int) (e.getY() / ROW_WIDTH);  
                if (board[xPos][yPos] == '+') {// 判断是否下过棋  
                    board[xPos][yPos] = player ? 'b' : 'w'; // 给虚拟键盘赋值  
                    map.repaint(); // 通过读取board数组进行贴图  
                    if (isWin(xPos, yPos)) {// 如果有满足胜利条件的玩家了  
                        map.repaint(); // 刷新图像  
                        String str = player ? "黑方胜利" : "白方胜利";  
                        JOptionPane.showMessageDialog(null, str, "游戏结束",  
                                JOptionPane.PLAIN_MESSAGE); // 弹出消息框  
                        clearMap(); // 清空棋盘  
                        map.repaint(); // 刷新棋盘  
                        player = true; // 新一局继续黑子先下  
                    } else {  
                        player = player ? false : true; // 切换玩家  
                    }  
                }  
            }  
        });  
        // 点击重新开始事件  
        items[0].addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                String str = "是否要重新开始游戏?";  
                // 添加消息对话框  
                if (JOptionPane.showConfirmDialog(null, str, "重新开始",  
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {  
                    clearMap(); // 清空棋盘  
                    map.repaint(); // 刷新棋盘  
                    player = true; // 玩家为黑棋  
                }  
            }  
        });  
        // 点击退出事件  
        items[1].addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                String str = "是否要退出游戏?";  
                // 添加消息对话框  
                if (JOptionPane.showConfirmDialog(null, str, "重新开始",  
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {  
                    System.exit(0); // 退出  
                }  
            }  
        });  
        // 点关闭按钮事件  
        frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                String str = "是否要退出游戏?";  
                // 添加消息对话框  
                if (JOptionPane.showConfirmDialog(null, str, "退出游戏",  
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {  
                    System.exit(0); // 退出  
                }  
            }  
        });  
        bar.add(game);  
        frame.setJMenuBar(bar);  
        frame.add(map);  
        frame.pack();  
        frame.setLocation(250, 50);  
        frame.setResizable(false);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    }  
  
    /** 
     * 纵向找 
     */  
    protected boolean find(int x, int y) {  
        int i, num = 1;  
        char temp = player ? 'b' : 'w';  
        for (i = x + 1; i < 15; i++) {// 向下找  
            if (board[i][y] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        for (i = x - 1; i >= 0; i--) {// 向上找  
            if (board[i][y] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        return false;  
    }  
  
    /** 
     * 横向找 
     */  
    protected boolean find2(int x, int y) {  
        int i, num = 1;  
        char temp = player ? 'b' : 'w';  
        for (i = y + 1; i < 15; i++) { // 向右找  
            if (board[x][i] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        for (i = y - 1; i >= 0; i--) {// 向左找  
            if (board[x][i] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        return false;  
    }  
  
    /** 
     * \方向 
     */  
    protected boolean find3(int x, int y) {  
        int i, j, num = 1;  
        char temp = player ? 'b' : 'w';  
        for (i = x + 1, j = y + 1; i < 15 && j < 15; i++, j++) {// 向下方  
            if (board[i][j] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        for (i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {// 向上方  
            if (board[i][j] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        return false;  
    }  
  
    /** 
     * /方向 
     */  
    protected boolean find4(int x, int y) {  
        int i, j, num = 1;  
        char temp = player ? 'b' : 'w';  
        for (i = x + 1, j = y - 1; i < 15 && j >= 0; i++, j--) {// 向下  
            if (board[i][j] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        for (i = x - 1, j = y + 1; i >= 0 && j < 15; i--, j++) { // 向上  
            if (board[i][j] == temp) {  
                num++;  
                if (num == 5) {  
                    return true;  
                }  
            } else {  
                break;  
            }  
        }  
        return false;  
    }  
  
    /** 
     *判断胜负 
     */  
    protected boolean isWin(int x, int y) {  
        return (find(x, y) || find2(x, y) || find3(x, y) || find4(x, y));  
    }  
  
    /** 
     * 内部容器类，用于实现图像处理 
     */  
    private class GameMap extends JPanel {  
        private static final long serialVersionUID = 16578987565248L;  
  
        public void paintComponent(Graphics g) {  
            super.paintComponent(g);  
            // 棋盘  
            g.setColor(new Color(200, 100, 50)); // 设为桔黄色  
            g.fillRect(0, 0, ROW_WIDTH * (BOARD_SIZE + 1), ROW_WIDTH  
                    * (BOARD_SIZE + 1)); // 填充棋盘  
            g.setColor(Color.black); // 设为黑色  
            for (int i = 0; i < BOARD_SIZE; i++) {// 画竖线  
                g.drawLine(SPACE + ROW_WIDTH * i, SPACE, SPACE + ROW_WIDTH * i,  
                        SPACE + ROW_WIDTH * (BOARD_SIZE - 1));  
            }  
            for (int i = 0; i < BOARD_SIZE; i++) {// 画横线  
                g.drawLine(SPACE, SPACE + ROW_WIDTH * i, SPACE + ROW_WIDTH  
                        * (BOARD_SIZE - 1), SPACE + ROW_WIDTH * i);  
            }  
            // 画点  
            g.fillOval(SPACE + 3 * ROW_WIDTH - 3, SPACE + 3 * ROW_WIDTH - 3, 7,  
                    7);  
            g.fillOval(SPACE + 11 * ROW_WIDTH - 3, SPACE + 3 * ROW_WIDTH - 3,  
                    7, 7);  
            g.fillOval(SPACE + 3 * ROW_WIDTH - 3, SPACE + 11 * ROW_WIDTH - 3,  
                    7, 7);  
            g.fillOval(SPACE + 7 * ROW_WIDTH - 3, SPACE + 7 * ROW_WIDTH - 3, 7,  
                    7);  
            g.fillOval(SPACE + 11 * ROW_WIDTH - 3, SPACE + 11 * ROW_WIDTH - 3,  
                    7, 7);  
  
            // 棋子  
            // 遍历数组，绘制棋子。  
            for (int i = 0; i < BOARD_SIZE; i++) {  
                for (int j = 0; j < BOARD_SIZE; j++) {  
                    if (board[i][j] == 'b') {// 绘制黑棋  
                        g.setColor(Color.black);  
                        g.fillOval(SPACE + i * ROW_WIDTH - ROW_WIDTH / 2, SPACE  
                                + j * ROW_WIDTH - ROW_WIDTH / 2, ROW_WIDTH,  
                                ROW_WIDTH);  
                    }  
                    if (board[i][j] == 'w') {// 绘制白棋  
                        g.setColor(Color.white);  
                        g.fillOval(SPACE + i * ROW_WIDTH - ROW_WIDTH / 2, SPACE  
                                + j * ROW_WIDTH - ROW_WIDTH / 2, ROW_WIDTH,  
                                ROW_WIDTH);  
                    }  
                }  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        FiveChessGame game = new FiveChessGame();  
        game.start();  
    }  
} 