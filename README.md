# RMI File Server

A server-client CLI application using Java RMI (Remote Method Invocation).

## Usage (Commands)

#### ls
```
ls path
```

Shows files in `path`. The argument is required and if you want to list the files in base directory type:

```
ls .
```
#### mkdir
```
mkdir path/dirname
```
Creates a directory `dirname` on `path`. If no `path` is given, the directory will be created on base directory.

#### touch
```
touch path/file.txt
```
Creates a file `file.txt` on `path`. If no `path` is given, the file will be created on base directory.

#### cat 
```
cat file.txt
```
Shows the contents in `file.txt`.

#### mv
```
mv source_path destination_path
```
Moves file or directory from `source_path` to `destination_path`.

#### rm
```
rm path
```
Removes a file or empty directory `path`.

#### pwd
```
pwd
```
Shows the base directory.

#### exit
Exits command line.

## TODO
#### chline
`chline n file.txt`

This command will replace the content of the line `n` from file `file.txt` with the contents entered in a prompt.

