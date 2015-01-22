/*
 * TextCell.cpp
 *
 *  Created on: Dec 19, 2014
 *      Author: ubuntumm2m
 */

#include "TextCell.h"

TextCell::TextCell(int row, int col) :
		Cell(row, col) {
	// Auto-generated constructor stub
	this->content = nullptr;

}

TextCell::TextCell(const int row, const int col, const std::string& content) :
		Cell(row, col) {
	this->content = content;
}

TextCell::~TextCell() {
	// Auto-generated destructor stub
}

double TextCell::getCellValueAsFloatingPoint() {
	return 0;
}

int TextCell::getCellValueAsInteger() {
	return 0;
}

std::string TextCell::getCellValueAsText() {
	return this->content;
}
