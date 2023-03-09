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
	private int guess;
	private String gameState;

	public GuessBean() {
		restart();
	}

	public void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}

	public void setGuessesMade(int guessesMade) {
		this.guessesMade = guessesMade;
	}

	public void setGameState(String gameState) {
		this.gameState = gameState;
	}

	public int getNumberToGuess() {
		System.out.println("getNumberToGuess");
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

	public void guess() {
		guessesMade++;

		if (this.guess == numberToGuess) {
			gameState = "Ganaste el premio de " + prize + "!";
		} else {
			gameState = "Fallaste. Sigue intentando.";
		}
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public void restart() {
		Random random = new Random();
		numberToGuess = random.nextInt(10) + 1;
		guessesMade = 0;
		prize = 100;
		gameState = "Intente adivinar un número entre 1 y 10.";
	}

}
