/*
 * main.cpp
 *
 *  Created on: Dec 19, 2014
 *      Author: ubuntumm2m
 */
#include "Spreadsheet.h"
#include <iostream>
int main() {
	Spreadsheet mySpreadSheet(3, 3);

	for (unsigned int i = 0; i < mySpreadSheet.getRows(); i++) {
		for (unsigned int j = 0; j < mySpreadSheet.getCols(); j++) {
			if (i % 2 == 0) {
				mySpreadSheet.setContent(i, j, 2);
			} else {
				mySpreadSheet.setContent(i, j, "test");
			}
		}
	}

	//print the spreadsheet
	std::cout << "Saved Matrix: " << std::endl;
	mySpreadSheet.print();
	//save it to file
	mySpreadSheet.saveToFile();
	try{
		mySpreadSheet.setContent(mySpreadSheet.getRows()+1, mySpreadSheet.getCols()+1,"out of bounds");
	}

	catch (outOfBounds&){
		std::cout << "Index out of bounds, value not saved" << std::endl;
	}
	//print sumRows
	std::cout << "sumRows(fila 2): " << mySpreadSheet.sumRow(2) << std::endl;
	//print sumCols
	std::cout << "sumCols(columna 1): " << mySpreadSheet.sumCol(1) << std::endl;

	return 0;
}

