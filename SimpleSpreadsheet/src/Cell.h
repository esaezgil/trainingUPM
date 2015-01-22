/*
 * Cell.h
 *
 *  Created on: 17/12/2014
 *      Author: alumno
 */
#include<string>
#include<sstream>

#ifndef CELL_H_
#define CELL_H_

class Cell {
public:
	Cell();
	Cell(unsigned int row, unsigned int col);
	virtual ~Cell();
	virtual int getCellValueAsInteger();
	virtual double getCellValueAsFloatingPoint();
	virtual std::string getCellValueAsText();

private:
	bool empty;
	int row;
	int col;

protected:
	unsigned int getRow();
	unsigned int getCol();
	std::string getValueAsText(int content);
	std::string getValueAsText(double content);
};

#endif /* CELL_H_ */
