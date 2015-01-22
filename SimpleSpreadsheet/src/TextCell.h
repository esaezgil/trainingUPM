/*
 * TextCell.h
 *
 *  Created on: Dec 19, 2014
 *      Author: ubuntumm2m
 */
#include "Cell.h"
#include <cstring>
#ifndef TEXTCELL_H_
#define TEXTCELL_H_

//using namespace std;

class TextCell: public Cell {
public:
	TextCell(int row, int col);
	TextCell(const int row, const int col, const std::string& content);
	virtual ~TextCell();
	int getCellValueAsInteger();
	double getCellValueAsFloatingPoint();
	std::string getCellValueAsText();
private:
	std::string content;
};

#endif /* TEXTCELL_H_ */
