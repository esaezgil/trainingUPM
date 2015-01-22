/*
 * FloatingPointCell.h
 *
 *  Created on: Dec 19, 2014
 *      Author: ubuntumm2m
 */
#include "Cell.h"
#include <sstream>
#include <string>

#ifndef FLOATINGPOINTCELL_H_
#define FLOATINGPOINTCELL_H_

class FloatingPointCell: public Cell {
public:
	FloatingPointCell(int row, int col, float content);
	FloatingPointCell(int row, int col);
	virtual ~FloatingPointCell();
	int getCellValueAsInteger();
	double getCellValueAsFloatingPoint();
	std::string getCellValueAsText();

private:
	float content;

};

#endif /* FLOATINGPOINTCELL_H_ */
