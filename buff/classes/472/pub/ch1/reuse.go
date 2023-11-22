// gccgo -g -o reuse reuse.go && ./reuse

package main

type IPerson interface { Name() string }
type Person struct { name string }

type IStudent interface { IPerson }
type Student struct {
	Person						// is-a: inheritance
	mom Person					// has-a: composition
	dad Person					// has-a: composition
}

func (s *Student) Name() string {
	return s.name
	// return s.mom.name
	// return s.dad.name
}

func main() {
	s:=new(Student)
	s=s
}
