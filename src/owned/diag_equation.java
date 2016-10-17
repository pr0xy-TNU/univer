package owned;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


class DiagEquation {
    public static Random randNumber;
    public static float[] coef = new float[5];
    public static String[] coefString = new String[]{"a", "b", "c", "d"};
    public static int id = 0;
    public static boolean isWanted = false;
    public static int iterationCount = 0;

    static class Chromosome {

        public int[] points;
        public float kSurvival;
        public int cId;

        public Chromosome() {
            points = new int[4];
            this.cId = id;
            id++;
        }

        public int getMaxElementForIndex() {
            int temp = 0;
            int index = 0;
            for (int i = 0; i < points.length; i++) {
                if (temp < points[i]) {
                    temp = points[i];
                    index = i;
                }
            }
            return index;
        }

        public void setPoints(int leftBorder, int rightBorder) {
            randNumber = new Random(rightBorder - leftBorder);
            float temp;
            for (int i = 0; i < points.length; i++) {
                temp = (float) Math.random() * (rightBorder - leftBorder) + leftBorder + 1;
                points[i] = new BigDecimal(temp).setScale(0, RoundingMode.UP).intValue();
            }
        }

        public float getkSurvival() {
            float survival = 0;
            for (int i = 0; i < points.length; i++) {
                survival += points[i] * coef[i];
            }

            //Отнимаем правую сторону уравнения
            survival -= coef[points.length];
            this.kSurvival = new BigDecimal(survival).setScale(1, RoundingMode.UP).floatValue();
            return this.kSurvival;
        }

        //Полуаем все данные по хромосоме
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%2s : ", this.cId));
            for (int i = 0; i < points.length; i++) {
                builder.append(String.format("%4s   ", points[i]));
            }
            builder.append(String.format("k = %4s  ", this.getkSurvival()));
            return builder.toString();
        }


        //Получаем уравнение в исходном виде
        public String getEquastion() {
            StringBuilder equastion = new StringBuilder();
            for (int i = 0; i < coef.length - 1; i++) {
                equastion.append(coefString[i]);
                equastion.append(" * ");
                equastion.append(coef[i]);
                if (i == coef.length - 2)
                    break;
                else
                    equastion.append(" + ");
            }
            equastion.append(" = ");
            equastion.append(coef[coef.length - 1]);
            return equastion.toString();
        }
    }

    static class ChromoContainer {
        public ArrayList<Chromosome> list;
        private int size;
        private float fitness;

        public ChromoContainer(int size) {
            list = new ArrayList<>(size);
            this.size = size;
            this.fitness = 0;
        }

        //Получаем хромосому
        public void setList(int left, int right) {
            for (int i = 0; i < 5; i++) {
                Chromosome instance = new Chromosome();
                instance.setPoints(left, right);
                list.add(instance);
            }
        }

        public float getFitness() {
            float totalGenFitness = 0;
            for (Chromosome item : list
                    ) {
                totalGenFitness += item.getkSurvival();
            }
            totalGenFitness = new BigDecimal(totalGenFitness / this.size()).setScale(2, RoundingMode.UP).floatValue();
            this.fitness = totalGenFitness;
            return this.fitness;
        }

        public void showList() {
            for (Chromosome item : list
                    ) {
                System.out.println(item.toString());
            }
            System.out.println(this.getFitness());
            System.out.println();
        }


        public int size() {
            return this.size;
        }

        public void addChromosome(Chromosome test) {
            this.list.add(test);
        }

        public Chromosome getChromosome(int index) {
            return this.list.get(index);
        }

        public void getSorterContainerByFitness() {
            Chromosome temp;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).getkSurvival() < list.get(j).getkSurvival()) {
                        temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }

        }


        public int chekcAnswer() {
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getkSurvival() == 0) {
                    index = i;
                }
            }
            return index;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите коэфициенты");
        String data = scanner.nextLine();
        int leftBorder, rightBorder = 1;

        String[] dateParse = data.trim().split(" ");
        for (int i = 0; i < coef.length; i++) {
            coef[i] = Float.parseFloat(dateParse[i]);
        }
        System.out.println("Введите границы, сначала левую потом правую");
        String[] border = scanner.nextLine().trim().split(" ");
        leftBorder = Integer.parseInt(border[0]);
        rightBorder = Integer.parseInt(border[1]);
        // Формируем контейнеры с хромосомами: папа мама ребенок и корневой контейнер

        ChromoContainer coreContainer = new ChromoContainer(4);

        Chromosome answer = new Chromosome();


        coreContainer.setList(leftBorder, rightBorder);
        System.out.println("Core generation");
        coreContainer.showList();
        while (!isWanted) {
            System.out.println("Iterration : " + iterationCount);
            ChromoContainer parentMother = new ChromoContainer(4);
            ChromoContainer parentFather = new ChromoContainer(4);
            ChromoContainer children = new ChromoContainer(4);
            Map<Integer, Float> orderPairs = getOrderPairs(coreContainer);
            int inc = 0;
            //РАсскидываем 5 лучьших пар по родителям
            for (Map.Entry<Integer, Float> pair : orderPairs.entrySet()
                    ) {
                if (inc == 5)
                    break;
                else {
                    int number1 = pair.getKey() / 10;
                    int number2 = pair.getKey() % 10;
                    parentFather.addChromosome(coreContainer.getChromosome(number1 - 1));
                    parentMother.addChromosome(coreContainer.getChromosome(number2 - 1));
                    inc++;
                }
            }

            System.out.println("Father:");
            parentFather.showList();
            System.out.println("Mother:");
            parentMother.showList();

            //Процесс формирования потомства
            System.out.println("Children: ");
            for (int i = 0, pos = 1; i <= coreContainer.size(); i++) {
                Chromosome chromosome = new Chromosome();
                if (pos == 4) {
                    pos = 1;
                }
                System.arraycopy(parentFather.list.get(i).points, 0, chromosome.points, 0, pos);
                System.arraycopy(parentMother.list.get(i).points, pos, chromosome.points, pos, chromosome.points.length - pos);
                children.addChromosome(chromosome);
                pos++;
            }
            children.showList();
            //Мутация
            System.out.println("Mutation children: ");
            children = getMutation(children);
            children.showList();
            System.out.println();
            ChromoContainer allChromosome = getAllGeneration(coreContainer, children);
            System.out.println("All generation: ");
            allChromosome.showList();
            System.out.println("New core generation: ");
            for (int i = 0; i < 5; i++) {
                coreContainer.list.set(i, allChromosome.list.get(i));
            }
            coreContainer.showList();
            if (coreContainer.chekcAnswer() != 0) {
                isWanted = true;
            } else if (coreContainer.list.get(0).getkSurvival() < 0) {
                isWanted = true;
            }
            Thread.sleep(500);
            iterationCount++;
        }
        System.out.printf("Я нашел корни уравнения за %s итераций и они равны: ", iterationCount);
        System.out.println();
        System.out.println(answer.getEquastion());

    }

    public static ChromoContainer getAllGeneration(ChromoContainer core, ChromoContainer children) {
        ChromoContainer tempContainer = new ChromoContainer(10);
        for (int i = 0; i <= core.size(); i++) {
            tempContainer.addChromosome(core.list.get(i));
        }
        for (int i = 0; i <= children.size(); i++) {
            tempContainer.addChromosome(children.list.get(i));
        }
        tempContainer.getSorterContainerByFitness();
        return tempContainer;
    }

    // Принцип таков, что мы ищем в массиве максимальный эдлемент и уменьшаем его по каждому элементу масива
    // Гдесдать ошибка с отрицательными коэффициентами
    public static ChromoContainer getMutation(ChromoContainer instance) {
        for (int i = 0; i < instance.size(); i++) {
            //temp = (float) Math.random() * (rightBorder - leftBorder) + leftBorder + 1;
            int indexOfMaxElement = instance.list.get(i).getMaxElementForIndex();
            int element = instance.list.get(i).points[indexOfMaxElement];
            int newValue = (int) (Math.random() * (element - 1) + 2);
            int value = 0;
            for (int j = 0; j < coef.length; j++) {
                value += newValue * coef[j];
            }
            if (value - instance.list.get(i).points[3] > 0) {
                instance.list.get(i).points[indexOfMaxElement] = newValue;
            }else{
                instance.list.get(i).points[indexOfMaxElement] = element;
            }

        }
        return instance;
    }

    //Множесто всех возможных пар без повторения
    public static Set<Integer> getRandomPairs() throws InterruptedException {
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                int numer1 = i;
                int numer2 = j;
                if (i == j)
                    continue;
                else
                    resultSet.add(i * 10 + j);
            }
        }

        return resultSet;
    }

    // Мапа для случайного множества
    public static Map<Integer, Float> getOrderPairs(ChromoContainer container) throws InterruptedException {
        Set<Integer> allPairs = getRandomPairs();

        Map<Integer, Float> resultMap = new HashMap<>();
        for (Integer item : allPairs
                ) {
            int tempPair = item;
            int firstNumber = tempPair / 10;
            int secondNumber = tempPair % 10;
            // Потому что так надо!!!! -1
            float sum = container.getChromosome(firstNumber - 1).getkSurvival() + container.getChromosome(secondNumber - 1).getkSurvival();
            resultMap.put(item, sum);
        }

        //Берем первые 5 пар, так как у них сые маленькие коэффициенты
        return sortByValue(resultMap);
    }

    //Сортировка по возрастанию (Map)
    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
