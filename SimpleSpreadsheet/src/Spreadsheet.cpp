/*
 * Spreadsheet.cpp
 *
 *  Created on: 17/12/2014
 *      Author: alumno
 */

#include "Spreadsheet.h"
#include <iostream>

Spreadsheet::Spreadsheet(unsigned int rows, unsigned int cols) :
		rows(rows), cols(cols) {

	this->cell = new Cell**[rows];
	for (unsigned int i = 0; i < rows; i++) {
		this->cell[i] = new Cell*[cols];
		for (unsigned int j = 0; j < cols; j++) {
			this->cell[i][j] = new Cell(i, j);
		}
	}
}

Spreadsheet::~Spreadsheet() {
// Auto-generated destructor stub
	for (unsigned int i = 0; i < this->getRows(); i++) {
		for (unsigned int j = 0; j < this->getCols(); j++) {
			delete this->cell[i][j];
		}
		delete[] this->cell[i];
	}
	delete[] this->cell;
}

unsigned int Spreadsheet::getRows() const {
	return this->rows;
}

unsigned int Spreadsheet::getCols() const {
	return this->cols;
}

void Spreadsheet::setContent(unsigned int row, unsigned int col, int content) {
	/**free cell[i][j]; xq ya esta inicializada a cell
	y si hay otra cosa me lo cargo directamente*/
	if(row > this->getRows()-1 || col > this->getCols()-1){
		throw outOfBounds();
	}
	delete this->cell[row][col];
	IntergerCell *integerCell = new IntergerCell(row, col, content);
	this->cell[row][col] = integerCell;
}

void Spreadsheet::setContent(unsigned int row, unsigned int col, double content) {
	if(row > this->getRows()-1 || col > this->getCols()-1){
		throw outOfBounds();
	}
	delete this->cell[row][col];
	this->cell[row][col] = new FloatingPointCell(row, col, content);
}

void Spreadsheet::setContent(unsigned int row, unsigned int col, std::string content) {
	//this->content = (int) content;
	if(row > this->getRows()-1 || col > this->getCols()-1){
		throw outOfBounds();
	}
	delete this->cell[row][col];
	this->cell[row][col] = new TextCell(row, col, content);
}

void Spreadsheet::saveToFile() {
	std::ofstream out("fichero.txt");
	for (int i = 0; i < rows; i++) {
		//out << "|";
		for (int j = 0; j < cols; j++) {
			std::string cellContent = this->cell[i][j]->getCellValueAsText();
			out << cellContent;
			out << "|";
		}
		out << "\n";
	}
	out.close();
}

void Spreadsheet::print() {

	for (int i = 0; i < rows; i++) {
		//out << "|";
		for (int j = 0; j < cols; j++) {
			std::cout << this->cell[i][j]->getCellValueAsText();
			std::cout << "|";
		}
		std::cout << "\n";
	}
}

double Spreadsheet::sumRow(unsigned int rowIndex) const {
	int result = 0;
	for (unsigned int i = 0; i < this->getCols(); i++) {
		result += this->cell[rowIndex][i]->getCellValueAsFloatingPoint();
	}
	return result;
}

double Spreadsheet::sumCol(unsigned int colIndex) const {
	int result = 0;
	for (unsigned int i = 0; i < this->getRows(); i++) {
		result += this->cell[i][colIndex]->getCellValueAsFloatingPoint();
	}
	return result;
}
