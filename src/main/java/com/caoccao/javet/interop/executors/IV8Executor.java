/*
 *   Copyright (c) 2021. caoccao.com Sam Cao
 *   All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.caoccao.javet.interop.executors;

import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.exceptions.JavetIOException;
import com.caoccao.javet.interop.IV8Executable;
import com.caoccao.javet.interop.V8Runtime;
import com.caoccao.javet.interop.V8ScriptOrigin;
import com.caoccao.javet.values.reference.V8Module;
import com.caoccao.javet.values.reference.V8Script;

@SuppressWarnings("unchecked")
public interface IV8Executor extends IV8Executable {
    default V8Script compileScript() throws JavetException {
        return compileScript(true);
    }

    V8Script compileScript(boolean resultRequired) throws JavetException;

    default void compileScriptVoid() throws JavetException {
        compileScript(false);
    }

    default V8Module compileV8Module() throws JavetException {
        return compileV8Module(true);
    }

    V8Module compileV8Module(boolean resultRequired) throws JavetException;

    default void compileV8ModuleVoid() throws JavetException {
        compileV8Module(false);
    }

    default String getResourceName() {
        return getV8ScriptOrigin().getResourceName();
    }

    default IV8Executor setResourceName(String resourceName) {
        getV8ScriptOrigin().setResourceName(resourceName);
        return this;
    }

    default boolean isModule() {
        return getV8ScriptOrigin().isModule();
    }

    default IV8Executor setModule(boolean module) {
        getV8ScriptOrigin().setModule(module);
        return this;
    }

    String getScriptString() throws JavetIOException;

    V8Runtime getV8Runtime();

    V8ScriptOrigin getV8ScriptOrigin();
}