/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/**
 * @test
 * @bug 7200264
 * @summary 7192963 changes disabled shift vectors
 * @requires vm.cpu.features ~= ".*sse2.*" & vm.debug & vm.flavor == "server"
 * @library /test/lib /
 * @run driver compiler.c2.cr7200264.TestSSE2IntVect
 */

package compiler.c2.cr7200264;

public class TestSSE2IntVect {
    public static void main(String[] args) throws Throwable {
        TestDriver test = new TestDriver();
        test.addExpectedVectorization("AddVI", 4);
        test.addExpectedVectorization("SubVI", 4);
        test.addExpectedVectorization("AndV", 3);
        test.addExpectedVectorization("OrV", 3);
        test.addExpectedVectorization("XorV", 3);
        test.addExpectedVectorization("LShiftVI", 5);
        test.addExpectedVectorization("RShiftVI", 3);
        test.addExpectedVectorization("URShiftVI", 3);
        test.run();
    }
}
