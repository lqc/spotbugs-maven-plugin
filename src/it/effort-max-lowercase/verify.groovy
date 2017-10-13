/*
 * Copyright (C) 2006-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

File findbugXml = new File(basedir, 'target/findbugsXml.xml')
assert findbugXml.exists(), "Analysis was not performed"

File buildLog = new File(basedir, "build.log")
def matchedLines = buildLog.readLines().grep(~/^.*Findbugs arg is -effort:max$/)
assert matchedLines.size() == 1, "Failed to find effort:max in logs"
