/*
 * Spreadsheet.h
 *
 *  Created on: 17/12/2014
 *      Author: alumno
 */

#ifndef SPREADSHEET_H_
#define SPREADSHEET_H_
#include "Cell.h"
#include "FloatingPointCell.h"
#include "IntergerCell.h"
#include "TextCell.h"
#include <fstream>

class outOfBounds{
public:
	outOfBounds(){}
	~outOfBounds(){}
};

class Spreadsheet {
public:
	Spreadsheet(unsigned int rows, unsigned int cols);
	virtual ~Spreadsheet();
	void saveToFile();
	void setContent(unsigned int row, unsigned int col, int content);
	void setContent(unsigned int row, unsigned int col, double content);
	void setContent(unsigned int row, unsigned int col, std::string content);
	unsigned int getRows() const;
	unsigned int getCols() const;
	double sumRow(unsigned	int	rowIndex) const;
	double sumCol(unsigned	int	colIndex) const;
	void print();
private:
	int rows;
	int cols;
	Cell*** cell;
};

#endif /* SPREADSHEET_H_ */
