
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import figuras.*;
import figuras.dosDimensiones.conico;
import figuras.dosDimensiones.poligono;
import figuras.tresDimensiones.cono;
import figuras.tresDimensiones.piramide;


class Ventana extends JFrame implements ActionListener,KeyListener{
	
	JLabel txt1;
	JTextField num1;
	
	JLabel txt2;
	JTextField num2;
	
	JLabel txtPerimetro;
	JTextField perimetro;
	
	JLabel txtArea;
	JTextField area;
	
	JComboBox<String> op;
	
	JLabel txtExxplicacion;
	
	public Ventana() {
		getContentPane().setLayout(null);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Figuras");
		setVisible(true);
		
		JLabel txtop = new JLabel("Elige una figura");
		txtop.setBounds(100,10,100,20);
		add(txtop);
		
		
		op = new JComboBox<String>();
		op.addItem("Rombo");
		op.addItem("Circulo");
		op.addItem("Elipse");
		op.addItem("Cono");
		op.addItem("Piramide");
		
		op.setBounds(200,10,100,20);
		add(op);
		op.addActionListener(this);
		
		txt1 = new JLabel("Ancho");
		txt1.setBounds(100,40,100,20);
		add(txt1);
		
		num1 = new JTextField();
		num1.setBounds(200,40,100,20);
		add(num1);
		num1.addKeyListener(this);
		
		txt2 = new JLabel("Alto");
		txt2.setBounds(100,70,100,20);
		add(txt2);
		
		num2 = new JTextField();
		num2.setBounds(200,70,100,20);
		add(num2);
		num2.addKeyListener(this);
		
		txtArea = new JLabel("Area");
		txtArea.setBounds(100,100,100,20);
		add(txtArea);
		
		area = new JTextField("0");
		area.setBounds(200,100,100,20);
		add(area);
		area.addKeyListener(this);
		
		txtPerimetro = new JLabel("Perimetro");
		txtPerimetro.setBounds(100,130,100,20);
		add(txtPerimetro);
		
		perimetro = new JTextField("0");
		perimetro.setBounds(200,130,100,20);
		add(perimetro);
		perimetro.addKeyListener(this);
		
		txtExxplicacion = new JLabel("Utiliza el teorema de pitagoras para obtener un lado");
		txtExxplicacion.setBounds(25,160,550,20);
		add(txtExxplicacion);
		
	}
	
	public void mostrarAreaPerimetro(figura x) {
		if(x!=null) {
			double area = x.getArea();
			double perimetro = x.getPerimetro();
			
			area= area*100;
			perimetro=perimetro*100;
			
			int ae = 0;
			ae+=area;
			int pe = 0;
			pe+=perimetro;
			
			
			area = ae;
			area=area/100;
			
			perimetro = pe;
			perimetro=perimetro/100;
			
			
			this.area.setText(String.valueOf(area));
			this.perimetro.setText(String.valueOf(perimetro));
		}else {
			this.area.setText("0");
			this.perimetro.setText("0");
		}
	}
	
	public figura obtenerFigura() {
		
		if(num1.getText().length()==0||(num2.getText().length()==0 && !op.getSelectedItem().equals("Circulo"))){
			
		}else if(num1.getText().length()==0 && op.getSelectedItem().equals("Circulo")) {
			
		}else {
		
			if(op.getSelectedItem().equals("Rombo")) {
				poligono p = new poligono();
				return p.crearRombo(Double.valueOf(num1.getText()),Double.valueOf(num2.getText()));
				
			}else if(op.getSelectedItem().equals("Circulo")) {
				System.out.println(Double.valueOf(num1.getText()));
				conico C = new conico();
				return C.crearCirculo(Double.valueOf(num1.getText()));
				
			}else if(op.getSelectedItem().equals("Elipse")) {
				System.out.println(Double.valueOf(num1.getText()));
				conico C = new conico();
				return C.crearElipse(Double.valueOf(num1.getText()),Double.valueOf(num2.getText()));
				
			}else if(op.getSelectedItem().equals("Piramide")) {
				return new piramide(Double.valueOf(num1.getText()),Double.valueOf(num2.getText()));
			}else if(op.getSelectedItem().equals("Cono")) {
				return new cono(Double.valueOf(num1.getText()),Double.valueOf(num2.getText()));
			}
		}
		
		return null;
	}
	
	public boolean encontrarPunto(String txt) {
		for(int i=0;i<txt.length();i++) {
			if(txt.charAt(i)=='.')
				return true;
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource() == num1||e.getSource() == num2){
			if((e.getKeyChar()>='0'&&e.getKeyChar()<='9')||e.getKeyChar()=='.'||e.getKeyChar()==8) {
				
				if(e.getSource()==num1&&e.getKeyChar()=='.') {
					if(encontrarPunto(num1.getText())){
						e.consume();
					}
				}else if(e.getSource()==num2&&e.getKeyChar()=='.')
					if(encontrarPunto(num2.getText())){
						e.consume();
					}
				mostrarAreaPerimetro(null);
			}else
				e.consume();
		}else
			e.consume();
		mostrarAreaPerimetro(obtenerFigura());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		mostrarAreaPerimetro(obtenerFigura());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		remove(num2);
		if(!op.getSelectedItem().equals("Circulo")){
			add(num2);
		}
		
		
		if(op.getSelectedItem().equals("Cono")||op.getSelectedItem().equals("Piramide")) {
			txtArea.setText("Volumen");
		}
		
		if(op.getSelectedItem().equals("Rombo")) {
			txt1.setText("Ancho");
			txt2.setText("Alto");
			txtExxplicacion.setText("Utiliza el teorema de pitagoras para obtener un lado");
		}else if(op.getSelectedItem().equals("Circulo")) {
			txt1.setText("Radio");
			txt2.setText("");
			txtExxplicacion.setText("Operaciones normales");
		}else if(op.getSelectedItem().equals("Elipse")) {
			txt1.setText("Semi eje mayor");
			txt2.setText("Semi eje menor");
			txtExxplicacion.setText("Operaciones normales");
		}else if(op.getSelectedItem().equals("Piramide")) {
			txt1.setText("Lado de la base");
			txt2.setText("Altura");
			txtExxplicacion.setText("Una piramide cuadrada. Utiliza el teorema de pitagoras para obtener la altura del triangulo");
		}else if(op.getSelectedItem().equals("Cono")) {
			txt1.setText("Radio de la base");
			txt2.setText("Altura");
			txtExxplicacion.setText("Operaciones normales");
		}
		mostrarAreaPerimetro(obtenerFigura());
		
	}
	
}

public class prueba {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Ventana();
				
			}
		});
		
		
	}

}
