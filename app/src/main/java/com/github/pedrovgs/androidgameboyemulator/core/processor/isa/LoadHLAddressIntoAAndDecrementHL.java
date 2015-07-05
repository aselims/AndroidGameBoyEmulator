/*
 * Copyright (C) 2015 Pedro Vicente Gomez Sanchez.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.github.pedrovgs.androidgameboyemulator.core.processor.isa;

import com.github.pedrovgs.androidgameboyemulator.core.mmu.MMU;
import com.github.pedrovgs.androidgameboyemulator.core.processor.GBZ80;
import com.github.pedrovgs.androidgameboyemulator.core.processor.Register;

public class LoadHLAddressIntoAAndDecrementHL extends Instruction {

  LoadHLAddressIntoAAndDecrementHL(GBZ80 z80, MMU mmu) {
    super(z80, mmu);
  }

  @Override public void execute() {
    int address = z80.get16BitRegisterValue(Register.HL);
    byte memoryValue = mmu.readByte(address);
    z80.set8BitRegisterValue(Register.A, memoryValue);
    z80.setLastInstructionExecutionTime(2);
    int newHLRegisterValue = z80.get16BitRegisterValue(Register.HL) - 1;
    z80.set16BitRegisterValue(Register.HL, newHLRegisterValue);
  }
}
