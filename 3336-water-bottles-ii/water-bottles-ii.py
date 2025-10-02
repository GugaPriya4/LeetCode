class Solution(object):
    def maxBottlesDrunk(self, numBottles, numExchange):
      drank=numBottles
      empty=numBottles

      while empty>= numExchange:
        empty-=numExchange
        numExchange+=1
    
        drank+=1
        empty+=1
      return drank  

        