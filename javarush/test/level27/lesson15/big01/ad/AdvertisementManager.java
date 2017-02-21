package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;


import java.util.*;


/**
 * Created by Zerodur on 16.08.2016.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }


    public void processVideos() throws NoVideoAvailableException
    {
        List<Advertisement> advertisements = storage.list();

        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                {
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                } else
                {

                    long l1, l2;
                    l1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                    l2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                    if (l1 != l2) return Long.compare(l1, l2);
                }
                return 0;
            }
        });

        List<List<Advertisement>> listOfList = powerSet(advertisements);
        List<Advertisement> list = findVideos(listOfList);
        int timeLeft = timeSeconds;

        for (Advertisement advertisement : list)
        {

            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
            try
            {
                advertisement.revalidate();
            }
            catch (UnsupportedOperationException e)
            {
            }
            timeLeft -= advertisement.getDuration();

            if (timeLeft == 0) break;
        }

        if (timeLeft == timeSeconds)
            throw new NoVideoAvailableException();
    }

    //находим все возможные подмножества
    private  List<List<Advertisement>> powerSet(List<Advertisement> originalList)
    {
        List<List<Advertisement>> sets = new ArrayList<>();
        if (originalList.isEmpty())
        {
            sets.add(new ArrayList<Advertisement>());
            return sets;
        }
        List<Advertisement> list = new ArrayList<>(originalList);
        Advertisement head = list.get(0);
        List<Advertisement> rest = new ArrayList<>(list.subList(1, list.size()));
        for (List<Advertisement> set : powerSet(rest))
        {
            List<Advertisement> newSet = new ArrayList<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

//выбираем из подмножеств лист который нам подходит

    private List<Advertisement> findVideos(List<List<Advertisement>> listOfAdvertisements)
    {
        //лист из листов видео
        Iterator<List<Advertisement>> prevIterator = listOfAdvertisements.iterator();
        // удаляем пустые и видео без оплаченных показов
        while (prevIterator.hasNext())
        {
            List<Advertisement> currentList = prevIterator.next();
            if (currentList.isEmpty()) prevIterator.remove();
            for (Advertisement adv:currentList)
            {
                if (adv.getHits()==0) currentList.remove(adv);
            }
        }

        long maxAmount =0;

        List<Advertisement> finalAdvList = new ArrayList<>();

        //из оставшихся находим нужный и добавляем в finalAdvList

        Iterator<List<Advertisement>> iterator = listOfAdvertisements.iterator();
        while (iterator.hasNext())
        {

            long totalAmount=0;
            int totalTime =0;
            List<Advertisement> currentListOfList = iterator.next();

            for (Advertisement currentAdv :currentListOfList)
            {
                totalAmount +=currentAdv.getAmountPerOneDisplaying();
                totalTime +=currentAdv.getDuration();
            }

            if(totalTime<=timeSeconds){
                if(totalAmount>=maxAmount){
                    finalAdvList.clear();
                    finalAdvList =currentListOfList;
                    maxAmount = totalAmount;
                }
            }else {iterator.remove();}

        }

        return finalAdvList;
    }

    public static void main(String[] args)
    {
        new AdvertisementManager(3*800).processVideos();
    }

}