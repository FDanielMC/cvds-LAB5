package edu.eci.cvds.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class GuessBean {

	/**
	 * 
	 */
	private int numberToGuess;
	private int guessesMade;
	private int prize;
	private int guessNumber;
	private String gameState;
	private List<Integer> lista;

	public GuessBean() {
		lista = new ArrayList<Integer>();
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
		lista.add(guessNumber);
		if (this.guessNumber == numberToGuess) {
			gameState = "Ganaste el premio de " + prize + "!";
		} else {
			if (prize >= 10000 && !gameState.contains("Ganaste el premio de ")) {
				gameState = "Fallaste. Sigue intentando.";
				prize -= 10000;
			}
		}
	}

	public List<Integer> getLista() {
		return lista;
	}

	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}

	public int getGuessNumber() {
		return guessNumber;
	}

	public void setGuessNumber(int guessNumber) {
		this.guessNumber = guessNumber;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public void restart() {
		Random random = new Random();
		numberToGuess = random.nextInt(10) + 1;
		guessesMade = 0;
		prize = 100000;
		gameState = "Intente adivinar un número entre 1 y 10.";
	}

}