/*
 * IntergerCell.h
 *
 *  Created on: 17/12/2014
 *      Author: alumno
 */

#ifndef INTERGERCELL_H_
#define INTERGERCELL_H_
#include "Cell.h"
#include <string>
#include<sstream>

class IntergerCell: public Cell {

private:
	int content;
public:
	IntergerCell(int row, int col);
	IntergerCell(int row, int col, int content);
	virtual ~IntergerCell();
	int getCellValueAsInteger();
	double getCellValueAsFloatingPoint();
	std::string getCellValueAsText();
};

#endif /* INTERGERCELL_H_ */
