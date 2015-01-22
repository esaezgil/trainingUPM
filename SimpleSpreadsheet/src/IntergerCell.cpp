/*
 * IntergerCell.cpp
 *
 *  Created on: 17/12/2014
 *      Author: alumno
 */

#include "IntergerCell.h"

IntergerCell::IntergerCell(int row, int col, int content) :
		Cell(row, col), content(content) {
	// Auto-generated constructor stub
}

IntergerCell::IntergerCell(int row, int col) :
		Cell(row, col) {
	this->content = 0;
}

IntergerCell::~IntergerCell() {
	// Auto-generated destructor stub
}

double IntergerCell::getCellValueAsFloatingPoint() {
	return (double) this->content;
}

int IntergerCell::getCellValueAsInteger() {
	return this->content;
}

std::string IntergerCell::getCellValueAsText() {
	return getValueAsText(this->content);
}
