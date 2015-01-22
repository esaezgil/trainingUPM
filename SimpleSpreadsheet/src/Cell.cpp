/*
 * Cell.cpp
 *
 *  Created on: 17/12/2014
 *      Author: alumno
 */

#include "Cell.h"

Cell::Cell() {
	this->empty = 1;
	this->row = 0;
	this->col = 0;
}

Cell::Cell(unsigned int row, unsigned int col) {
	// Auto-generated constructor stub
	this->empty = 1;
	this->row = row;
	this->col = col;
}

Cell::~Cell() {
	// Auto-generated destructor stub
}

unsigned int Cell::getCol() {
	return this->col;
}

unsigned int Cell::getRow() {
	return this->row;
}

int Cell::getCellValueAsInteger() {
	return 0;
}
double Cell::getCellValueAsFloatingPoint() {
	return 0;
}
std::string Cell::getCellValueAsText() {
	return "no deberia salir esto!!";
}

std::string Cell::getValueAsText(int content) {
	std::string result;
	std::ostringstream convert;
	convert << content;
	return convert.str();
}

std::string Cell::getValueAsText(double content) { //http://www.cplusplus.com/articles/D9j2Nwbp/
	std::string result;
	std::ostringstream convert;
	convert << content;
	return convert.str();
}
