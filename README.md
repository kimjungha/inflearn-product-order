인프런 스프링부트 tdd study

1. only java 를 사용해서 test
   1-1. service, repository, entity 되는 class 직접 다 만들어서 생성자로 주입시켜서 테스트 진행
   1-2. 그냥 한 클래스에다가 inner class 로 만들고 test 성공 후에 upper class 로 f6 눌러서 그 때 다 밖으로 빼면 됌 -> 시간 아낄 수 있고, 한 파일안에서 확인하니 편함 
2. spring boot 사용해서 test
   2-1. @Component, @Transactional , @Repository , @Autowired 사용 
