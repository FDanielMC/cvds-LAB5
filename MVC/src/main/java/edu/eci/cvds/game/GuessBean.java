package edu.eci.cvds.game;

import java.io.Serializable;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class GuessBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberToGuess;
	private int guessesMade;
	private int prize;
	private String gameState;

	public GuessBean() {
		restart();
	}

	public int getNumberToGuess() {
		return numberToGuess;
	}

	public int getGuessesMade() {
		return guessesMade;
	}

	public int getPrize() {
		return prize;
	}

	public String getGameState() {
		return gameState;
	}

	public void guess(int guess) {
		guessesMade++;

		if (guess == numberToGuess) {
			gameState = "Ganaste el premio de " + prize + "!";
		} else {
			gameState = "Fallaste. Sigue intentando.";
		}
	}

	public void restart() {
		Random random = new Random();
		numberToGuess = random.nextInt(10) + 1;
		guessesMade = 0;
		prize = 100;
		gameState = "Intente adivinar un número entre 1 y 10.";
	}

}
