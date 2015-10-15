package celda;

public class Celda {

	protected int posX;
	protected int posY;
	protected Bomberman miBomberman;
	protected Enemigo miEnemigo;
	protected PowerUP miPowerUp;
	protected Estructura miEstructura;
	protected Nivel miNivel;
	protected Bomba miBomba;

	public Celda(int px, int py, Bomberman b, Enemigo e, PowerUp p,
			Estructura e, Nivel n) {
		posX = px;
		posY = py;
		miBomberman = b;
		miEnemigo = e;
		miPowerUp = p;
		miEstuctura = e;
		miNivel = n;
		miBomba = null;
	}

	public Celda(int px, int py, PowerUp p, Estructura e, Nivel n) {
		posX = px;
		posY = py;
		miBomberman = null;
		miEnemigo = null;
		miPowerUp = p;
		miEstuctura = e;
		miNivel = e;
		miBomba = null;
	}

	public void atravesar(Bomberman b) {
		if (miEstructura != null)
			Estructura.atravesar(b);
		else
			colocar(b);
	}

	public void atravesar(Enemigo e) {
		if (miEstructura != null)
			Estructura.atravesar(e);
		else
			colocar(e);
	}

	public void colocar(Bomberman b) {
		b.setCelda(this);
		miBomberman = b;
		if (hayEnemigo()) {
			miNivel.gameOver();
		}
	}

	public void colocar(Enemigo e) {
		if (!hayEnemigo()) {
			e.setCelda(this);
			miEnemigo = e;
			if (hayBomberman()) {
				miNivel.gameOver();
			}
		}
	}

	public void setEstructura(Estructura e) {
		miEstructura = e;
	}

	public void recibirExplosion() {
		if (miEstructura != null)
			miEstructura.recibirExplosion();
		quitarPersonaje();
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void quitarPersonaje() {
		if (hayBomberman()) {
			miBomberman = null;
			miNivel.gameOver();
		} else if (hayEnemigo()) {
			miEnemigo = null;
			miNivel.destruirEnemigo(miEnemigo);
		}
	}

	public Personaje getPersonaje() {
		if (hayBomberman())
			return miBomberman;
		else
			return miEnemigo;
	}

	public boolean hayBomberman() {
		return (miBomberman != null);
	}

	public boolean hayEnemigo() {
		return (miEnemigo != null);
	}

}