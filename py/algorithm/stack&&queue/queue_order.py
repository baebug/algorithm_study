'''
주의! 너무 느려서 개선이 필요함.
'''

# 가게에서 주문을 받는데, 일반 주문과 vip 주문으로 나뉜다.
# 주문이 밀려있을 때 vip 주문이 더 우선하여 들어간다.
# 주문 처리 순서를 구하여라. (주문이 들어오는 시간은 겹치지 않는다.)
# 주문 정보는 orders 를 통해 들어온다. (time, duration, vip)

# 근데 이렇게 하면 주문 순서를 모르는데? 시간이 안겹치니까 시간값만 알면 되나?

from collections import deque

nq = deque()
vq = deque()
curTime = 0
endTime = 0
result = []

# 일단 주문을 일반 주문과 vip 주문으로 나눈다.
for order in orders:
    if order.vip == 1:
        vq.append(order)
    else:
        nq.append(order)

# 지금 시간에 처리할 수 있는 주문이 없으면(nq와 vq의 0번 인덱스의 time 값과 비교) 시간을 + 1 해준다.
# order의 time이 curTime 보다 같거나 작아야 처리할 수 있는 주문이다.

# 둘 다 빌 때까지 반복 시행한다.
while vq or nq:
    # 우선적으로 endTime 이 curTime 보다 같거나 작아야 주문을 받을 수 있다.
    if endTime <= curTime:
        if not nq:
            if vq[0].time <= curTime:
                # vq의 주문을 받는다.
                # 즉 endTime 이 갱신된다.
                endTime = max(curTime, vq[0].time) + vq[0].duration
                index = orders.index(vq.popleft())
                result.append(index + 1)
            else:
                curTime += 1
        elif not vq:
            if nq[0] <= curTime:
                # nq의 주문을 받는다.
                endTime = max(curTime, nq[0].time) + nq[0].duration
                index = orders.index(nq.popleft())
                result.append(index + 1)
            else:
                curTime += 1
        else:
            if nq[0].time > curTime and vq[0].time > curTime:
                curTime += 1
            elif vq[0].time <= curTime:
                # vq의 주문을 받는다.
                # 즉 endTime 이 갱신된다.
                endTime = max(curTime, vq[0].time) + vq[0].duration
                index = orders.index(vq.popleft())
                result.append(index + 1)

            elif nq[0] <= curTime:
                # nq의 주문을 받는다.
                endTime = max(curTime, nq[0].time) + nq[0].duration
                index = orders.index(nq.popleft())
                result.append(index + 1)

    else:
        curTime += 1

return result

