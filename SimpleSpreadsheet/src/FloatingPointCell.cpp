/*
 * FloatingPointCell.cpp
 *
 *  Created on: Dec 19, 2014
 *      Author: ubuntumm2m
 */

#include "FloatingPointCell.h"

FloatingPointCell::FloatingPointCell(int row, int col, float content) :
		Cell(row, col), content(content) {
	// Auto-generated constructor stub
}

FloatingPointCell::FloatingPointCell(int row, int col) :
		Cell(row, col) {
	this->content = 0;
}

FloatingPointCell::~FloatingPointCell() {
	// Auto-generated destructor stub
}

int FloatingPointCell::getCellValueAsInteger() {
	return this->content; // TODO:automatic casting?
}

double FloatingPointCell::getCellValueAsFloatingPoint() {
	return this->content;
}
std::string FloatingPointCell::getCellValueAsText() {
	return getValueAsText(this->content);
}
