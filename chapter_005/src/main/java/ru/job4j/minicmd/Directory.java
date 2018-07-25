package ru.job4j.minicmd;

/*
* Please solve the following puzzle which simulates generic directory structures.
* The solution should be directory agnostic.
* Be succinct yet readable. You should not exceed more than 200 lines.
* Consider adding comments and asserts to help the understanding.
* Code can be compiled with javac Directory.java
* Code should be executed as: java -ea Directory (-ea option it's to enabled the assert)
*/

import java.util.*;

/**.
 * Class Shell implements the logic of the directory structures and executes input commands.
 * @author Mikhail Vlasov
 * @since 22.07.2018
 * @version 2
 */
class Shell {
    /**
     * Set that contains folders in root.
     */
    private HashSet<Folder> root;
    /**
     * LinkedList implements of the current pass using Deque functions acts as Stack.
     */
    private LinkedList<Folder> pathDeque;

    public Shell() {
        //Устанавливаем начальную позицию в корне.
        this.pathDeque = new LinkedList<Folder>();
        //Задаём список директорий.
        root = new HashSet<>();
        Folder foldr1 = new Folder("usr");
        Folder foldr2 = new Folder("lib");
        Folder foldr3 = new Folder("local");
        root.add(foldr1);
        root.add(foldr2);
        foldr1.addSubFolder(foldr3);
    }

    Shell cd(final String path) {
        //Если команда '/' то выходим в корневой каталог.
        if ("/".equals(path)) {
            pathDeque.clear();
            return this;
            //Если команда '//' то выходим в корневой каталог.
        } else if (path.startsWith("//")) {
            pathDeque.clear();
        }

        //Разбиваем входящую команду на подкоманды используя '/' как делитель.
        String[] pathParsed = path.split("/");
        for (String s : pathParsed) {
            if (s.isEmpty()) {
                continue;
            } else if ("..".equals(s)) {
                //Если команда '..', то поднимаемся на дерикторию вверх.
                if (!pathDeque.isEmpty()) {
                    pathDeque.pop();
                }
                //Если команда dir, то заходим в дерикторию dir.
            } else if (pathDeque.isEmpty()) {
                for (Folder f : root) {
                    if (f.getName().equals(s)) {
                        pathDeque.push(f);
                        break;
                    }
                }
            } else if (!pathDeque.isEmpty()) {
                for (Folder f : pathDeque.getFirst().subFolderList) {
                    if (f.getName().equals(s)) {
                        pathDeque.push(f);
                        break;
                    }
                }
            }
        }
        return this;
    }

    public String path() {
        StringBuilder pathString = new StringBuilder("/");
        if (!pathDeque.isEmpty()) {
            ListIterator<Folder> lit = pathDeque.listIterator(pathDeque.size());
            while (lit.hasPrevious()) {
                pathString.append(lit.previous().getName() + "/");
            }
            pathString.deleteCharAt(pathString.length() - 1);
        }
        return pathString.toString();
    }
    /**.
     * Class Folder implements one folder structure.
     * @author Mikhail Vlasov
     * @since 04.06.2018
     * @version 2
     */
    class Folder {
        /**
         * Name.
         */
        private String name;
        /**
         * Set of sub folders.
         */
        private HashSet<Folder> subFolderList;

        Folder(String name) {
            this.name = name;
            subFolderList = new HashSet<>();
        }

        void addSubFolder(Folder fld) {
            subFolderList.add(fld);
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Folder folder = (Folder) o;

            return name != null ? name.equals(folder.name) : folder.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

/**.
 * Class Directory solves the puzzle which simulates generic directory structures.
 * @author Mikhail Vlasov
 * @since 21.07.2018
 * @version 1
 */
public class Directory {
        public static void main(String[] args) {

            final Shell shell = new Shell();
            assert shell.path().equals("/");

            shell.cd("/");
            assert shell.path().equals("/");

            shell.cd("usr/..");
            assert shell.path().equals("/");

            shell.cd("usr").cd("local");
            shell.cd("../local").cd("./");
            assert shell.path().equals("/usr/local");

            shell.cd("..");
            assert shell.path().equals("/usr");

            shell.cd("//lib///");
            assert shell.path().equals("/lib");
        }
}